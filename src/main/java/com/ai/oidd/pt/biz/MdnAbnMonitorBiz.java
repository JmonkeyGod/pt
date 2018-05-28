package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.*;
import com.ai.oidd.pt.vo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import com.ai.oidd.pt.mapper.MdnAbnMonitorMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Asiainfo-OIDD
 * 高危监测
 *
 * @author sunbin-71738
 * @date 2018-05-15
 */
@Service
public class MdnAbnMonitorBiz extends BaseBiz<MdnAbnMonitorMapper, MdnAbnBehavor> {

    /**
     * 异常行为省份占比
     *
     * @param start
     * @param end
     * @return
     */
    public ObjectRestResponse<CommonProRatioVo> provinceRatioByDate(Integer start, Integer end) {

        List<MdnAbnCityCount> list = mapper.provinceRatioByDate(start, end);
        int local = 0;
        int outer = 0;
        for (MdnAbnCityCount temp : list){
            if(temp.getCode().equals("11")){
                local+=temp.getTotal();
            }else{
                outer+=temp.getTotal();
            }
        }
        CommonProRatioVo commonProRatioVo = new CommonProRatioVo();
        commonProRatioVo.setLocal(local);
        commonProRatioVo.setOuter(outer);
        ObjectRestResponse<CommonProRatioVo> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(commonProRatioVo);
        return entityObjectRestResponse;
    }


    /**
     * 异常行为本省排名
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<MdnAbnCityCount> provinceTopByDate(Integer start, Integer end) {
        List<MdnAbnCityCount> results = mapper.provinceTopByDate(start, end , "11");
        return new TableResultResponse<>(results.size(), results);
    }



    /**
     * 异常行为类型占比
     *
     * @param start
     * @param end
     * @return
     */
    public ObjectRestResponse<CommonTypeRatioVo> typeRatioByDate(Integer start, Integer end) {

        List<MdnAbnTypeCount> list = mapper.typeRatioByDate(start, end, "11");
        int call = 0;
        int sms = 0;
        int on = 0;
        for (MdnAbnTypeCount temp : list){
            if(temp.getType().equals("主叫")){
                call = temp.getTotal();
            }else if(temp.getType().equals("短信")){
                sms = temp.getTotal();
            }else if(temp.getType().equals("开机")){
                on = temp.getTotal();
            }
        }
        CommonTypeRatioVo commonTypeRatioVo = new CommonTypeRatioVo();
        commonTypeRatioVo.setCall(call);
        commonTypeRatioVo.setSms(sms);
        commonTypeRatioVo.setOn(on);
        ObjectRestResponse<CommonTypeRatioVo> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(commonTypeRatioVo);
        return entityObjectRestResponse;
    }



    /**
     * 异常行为类型本身按天统计
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<CommonTypeRatioByDayVo> typeStaByDate(Integer start, Integer end) {
        List<MdnAbnTypeCountByDay> list = mapper.typeStaByDate(start, end , "11");
        List<CommonTypeRatioByDayVo> results = new ArrayList<>();
        for(MdnAbnTypeCountByDay temp : list){
            int date = temp.getDate();
            Boolean flag = false;
            for(CommonTypeRatioByDayVo rs : results){
                if(rs.getDate()==date){
                    flag = true;
                    if(temp.getType().equals("主叫")){
                        rs.setCall(temp.getTotal());
                    }else if(temp.getType().equals("短信")){
                        rs.setSms(temp.getTotal());
                    }else if(temp.getType().equals("开机")){
                        rs.setOn(temp.getTotal());
                    }
                    break;
                }
            }
            if(!flag){
                CommonTypeRatioByDayVo newrs = new CommonTypeRatioByDayVo();
                newrs.setDate(temp.getDate());
                if(temp.getType().equals("主叫")){
                    newrs.setCall(temp.getTotal());
                }else if(temp.getType().equals("短信")){
                    newrs.setSms(temp.getTotal());
                }else if(temp.getType().equals("开机")){
                    newrs.setOn(temp.getTotal());
                }
                results.add(newrs);
            }
        }
        for(CommonTypeRatioByDayVo rs : results){
            rs.setAll(rs.getCall()+rs.getSms()+rs.getOn());
        }
        return new TableResultResponse<>(results.size(), results);
    }

    /**
     * 按条件查询
     *
     * @param vo
     * @return
     */
    public TableResultResponse<MdnAbnBehavor> queryAbnByExampleAndPage(MdnAbnMonitorVo vo) {
        Example example = new Example(MdnAbnBehavor.class);
        Example.Criteria criteria = example.createCriteria();
        int page = 1;
        int limit = 10;
        boolean isCriteria = false;

        if (null != vo) {
            String mdn = vo.getMdn();
            if (StringUtils.isNotEmpty(mdn)) {
                isCriteria = true;
                criteria.andEqualTo("mdn", mdn);
            }

            String imei = vo.getType();
            if (StringUtils.isNotEmpty(imei)) {
                isCriteria = true;
                criteria.andEqualTo("type", imei);
            }

            String terminalType = vo.getHcode();
            if (StringUtils.isNotEmpty(terminalType)) {
                isCriteria = true;
                criteria.andEqualTo("hcode", terminalType);
            }

            String sourceType = vo.getStatus();
            if (StringUtils.isNotEmpty(sourceType)) {
                isCriteria = true;
                criteria.andEqualTo("status", sourceType);
            }

            page = vo.getPage();
            limit = vo.getLimit();
        }

        if (0 == page && 0 == limit) {
            page = 1;
            limit = 10;
        }
        Page<Object> result = PageHelper.startPage(page, limit);

        List<MdnAbnBehavor> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
            System.out.println(list.size());
        } else {
            list = mapper.selectByExample(new Example(MdnAbnBehavor.class));
        }

        return new TableResultResponse<>(result.getTotal(), list);
    }


    /**
     * 异常类型top
     *
     * @param start
     * @param end
     * @return
     */
    public ObjectRestResponse<CommonTypeTopVo> typeTopByDate(Integer start, Integer end) {

        List<MdnAbnTypeTop> calllist = mapper.typeTopByDate(start, end,"11", "主叫");
        List<MdnAbnTypeTop> smslist = mapper.typeTopByDate(start, end, "11","短信");
        List<MdnAbnTypeTop> onlist = mapper.typeTopByDate(start, end, "11","开机");
        CommonTypeTopVo commonTypeTopVo = new CommonTypeTopVo();
        commonTypeTopVo.setCallData(calllist);
        commonTypeTopVo.setSmsData(smslist);
        commonTypeTopVo.setOnData(onlist);
        ObjectRestResponse<CommonTypeTopVo> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(commonTypeTopVo);
        return entityObjectRestResponse;
    }


}
