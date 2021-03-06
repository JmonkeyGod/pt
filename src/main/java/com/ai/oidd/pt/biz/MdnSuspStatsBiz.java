package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.MdnSuspStats;
import com.ai.oidd.pt.mapper.MdnSuspStatsMapper;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.MdnSuspStatsVo;
import com.ai.oidd.pt.vo.SourceTypeVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Asiainfo-OIDD
 * 疑似号码统计 biz
 *
 * @author sunbin-71738
 * @date 2018-05-17
 */
@Service
public class MdnSuspStatsBiz extends BaseBiz<MdnSuspStatsMapper, MdnSuspStats> {


    /**
     * 识别源占比
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<SourceTypeVo> sourceTypeRatioByDate(Integer start, Integer end) {

        List<CommonQty> qtys = mapper.countSourceTypeByDate(start, end);
        int total = mapper.selectCountByExample(new Example(MdnSuspStats.class));

        List<SourceTypeVo> sourceTypeVos = new ArrayList<>();
        SourceTypeVo vo;
        float ratio;
        for (CommonQty commonQty : qtys) {
            vo = new SourceTypeVo();
            vo.setSourceName(commonQty.getName());
            vo.setCounts(commonQty.getQty());
            ratio = (float) commonQty.getQty()/ total;
            vo.setRatio(ratio);
            sourceTypeVos.add(vo);
        }

        return new TableResultResponse<>(sourceTypeVos.size(), sourceTypeVos);
    }

    /**
     * 按天统计高危区域
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<CityCodeQty> countAreaByDate(Integer start, Integer end) {
        List<CityCodeQty> results = mapper.countAreaByDate(start, end, 0, 0);
        return new TableResultResponse<>(results.size(), results);
    }


    /**
     * 按天统计高危区域top10
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<CityCodeQty> countTopAreaByDate(Integer start, Integer end) {
        List<CityCodeQty> results = mapper.countAreaByDate(start, end, 0, 10);
        return new TableResultResponse<>(results.size(), results);
    }


    /**
     * 按条件查询
     *
     * @param vo
     * @return
     */
    public TableResultResponse<MdnSuspStats> queryByExampleAndPage(MdnSuspStatsVo vo) {
        Example example = new Example(MdnSuspStats.class);
        Example.Criteria criteria = example.createCriteria();
        boolean isCriteria = false;
        int page = 1;
        int limit = 10;
        if (null != vo) {
            String mdn = vo.getMdn();
            if (StringUtils.isNotEmpty(mdn)) {
                isCriteria = true;
                criteria.andEqualTo("mdn", mdn);
            }

            String sourceType = vo.getSourceType();
            if (StringUtils.isNotEmpty(sourceType)) {
                isCriteria = true;
                criteria.andEqualTo("sourceType", sourceType);
            }

            String sourceArea = vo.getSourceArea();
            if (StringUtils.isNotEmpty(sourceArea)) {
                isCriteria = true;
                criteria.andEqualTo("sourceArea", sourceArea);
            }

            String baseId = vo.getBaseId();
            if (StringUtils.isNotEmpty(baseId)) {
                isCriteria = true;
                criteria.andEqualTo("baseId", baseId);
            }

            Date start = vo.getStartTime();
            Date end = vo.getEndTime();
            if (null != start && null != end) {
                isCriteria = true;
                criteria.andBetween("time", start, end);
            }

            Date lastDateStart = vo.getLastDateStart();
            Date lastDateEnd = vo.getLastDateEnd();
            if (null != lastDateStart && null != lastDateEnd) {
                isCriteria = true;
                criteria.andBetween("lastUpdateDate", lastDateStart, lastDateEnd);
            }

            page = vo.getPage();
            limit = vo.getLimit();
        }


        if (0 == page && 0 == limit) {
            page = 1;
            limit = 10;
        }

        Page<Object> result = PageHelper.startPage(page, limit);

        List<MdnSuspStats> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
        }else {
            list = mapper.selectByExample(new Example(MdnSuspStats.class));
        }

        return new TableResultResponse<>(result.getTotal(), list);
    }

    /**
     * 按日期计算总量
     *
     * @param start
     * @param end
     * @return
     */
    public ObjectRestResponse<Integer> countMdnByDate(Integer start, Integer end) {
        ObjectRestResponse<Integer> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(mapper.countMdnByDate(start, end));
        return entityObjectRestResponse;
    }


}
