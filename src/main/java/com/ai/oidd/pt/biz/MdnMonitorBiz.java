package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.MdnMonitor;
import com.ai.oidd.pt.mapper.MdnMonitorMapper;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonDateQty;
import com.ai.oidd.pt.vo.MdnMonitorVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Asiainfo-OIDD
 * 高危监测
 *
 * @author sunbin-71738
 * @date 2018-05-15
 */
@Service
public class MdnMonitorBiz extends BaseBiz<MdnMonitorMapper, MdnMonitor> {

    /**
     * 高危终端占比
     *
     * @param start
     * @param end
     * @return
     */
    public ObjectRestResponse<Float> terminalRatioByDate(Integer start, Integer end) {
        ObjectRestResponse<Float> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(mapper.terminalRatioByDate(start, end));
        return entityObjectRestResponse;
    }

    /**
     * 高危终端按天
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<CommonDateQty> countTerminalByDate(Integer start, Integer end) {
        List<CommonDateQty> results = mapper.countTerminalByDate(start, end);
        return new TableResultResponse<>(results.size(), results);
    }

    /**
     * 高危号码占比
     *
     * @param start
     * @param end
     * @return
     */
    public ObjectRestResponse<Float> mdnRatioByDate(Integer start, Integer end) {
        ObjectRestResponse<Float> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(mapper.mdnRatioByDate(start, end));
        return entityObjectRestResponse;
    }

    /**
     * 高危号码按天
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<CommonDateQty> countMdnByDate(Integer start, Integer end) {
        List<CommonDateQty> results = mapper.countMdnByDate(start, end);
        return new TableResultResponse<>(results.size(), results);
    }

    /**
     * 高危区域按天
     *
     * @param start
     * @param end
     * @return
     */
    public TableResultResponse<CityCodeQty> countAreaByDate(Integer start, Integer end) {
        List<CityCodeQty> results = mapper.countAreaByDate(start, end);
        return new TableResultResponse<>(results.size(), results);
    }

    /**
     * 按条件查询
     *
     * @param vo
     * @return
     */
    public TableResultResponse<MdnMonitor> queryByExampleAndPage(MdnMonitorVo vo) {
        Example example = new Example(MdnMonitor.class);
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

            String imei = vo.getImei();
            if (StringUtils.isNotEmpty(imei)) {
                isCriteria = true;
                criteria.andEqualTo("imei", imei);
            }

            String terminalType = vo.getTerminalType();
            if (StringUtils.isNotEmpty(terminalType)) {
                isCriteria = true;
                criteria.andEqualTo("terminalType", terminalType);
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

            page = vo.getPage();
            limit = vo.getLimit();
        }

        if (0 == page && 0 == limit) {
            page = 1;
            limit = 10;
        }
        Page<Object> result = PageHelper.startPage(page, limit);

        List<MdnMonitor> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
            System.out.println(list.size());
        }else {
            list = mapper.selectByExample(new Example(MdnMonitor.class));
        }

        return new TableResultResponse<>(result.getTotal(), list);
    }
}
