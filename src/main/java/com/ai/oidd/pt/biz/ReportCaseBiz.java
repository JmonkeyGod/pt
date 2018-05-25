package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.ReportCase;
import com.ai.oidd.pt.mapper.ReportCaseMapper;
import com.ai.oidd.pt.vo.ReportCaseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Asiainfo-OIDD
 * 报案数据 biz
 *
 * @author sunbin-71738
 * @date 2018-05-17
 */
@Service
public class ReportCaseBiz extends BaseBiz<ReportCaseMapper, ReportCase> {
    /**
     * 按条件查询
     *
     * @param vo
     * @return
     */
    public TableResultResponse<ReportCase> queryByExampleAndPage(ReportCaseVo vo) {
        Example example = new Example(ReportCase.class);
        Example.Criteria criteria = example.createCriteria();
        boolean isCriteria = false;
        int page = 1;
        int limit = 10;
        if (null != vo) {
            String fraudMdn = vo.getFraudMdn();
            if (StringUtils.isNotEmpty(fraudMdn)) {
                isCriteria = true;
                criteria.andEqualTo("fraudMdn", fraudMdn);
            }

            String fraudedMdn = vo.getFraudedMdn();
            if (StringUtils.isNotEmpty(fraudedMdn)) {
                isCriteria = true;
                criteria.andEqualTo("fraudedMdn", fraudedMdn);
            }

            String type = vo.getType();
            if (StringUtils.isNotEmpty(type)) {
                isCriteria = true;
                criteria.andEqualTo("type", type);
            }

            String result = vo.getResult();
            if (StringUtils.isNotEmpty(result)) {
                isCriteria = true;
                criteria.andEqualTo("type", Integer.parseInt(result));
            }

            String loss = vo.getLoss();
            if (StringUtils.isNoneEmpty(loss)) {
                isCriteria = true;
                criteria.andEqualTo("loss", loss);
            }

            Date start = vo.getStartTime();
            Date end = vo.getEndTime();
            if (null != start && null != end) {
                isCriteria = true;
                criteria.andBetween("reportTime", start, end);
            }

            Date occurDateStart = vo.getOccurDateStart();
            Date occurDateEnd = vo.getOccurDateEnd();
            if (null != occurDateStart && null != occurDateEnd) {
                isCriteria = true;
                criteria.andBetween("occurTime", occurDateStart, occurDateEnd);
            }

            page = vo.getPage();
            limit = vo.getLimit();
        }


        if (0 == page && 0 == limit) {
            page = 1;
            limit = 10;
        }

        Page<Object> result = PageHelper.startPage(page, limit);

        List<ReportCase> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
        }else {
            list = mapper.selectByExample(new Example(ReportCase.class));
        }

        return new TableResultResponse<>(result.getTotal(), list);
    }
}
