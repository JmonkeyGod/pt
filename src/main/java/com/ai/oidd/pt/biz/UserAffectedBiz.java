package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserAffected;
import com.ai.oidd.pt.mapper.UserAffectedMapper;
import com.ai.oidd.pt.vo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Asiainfo-OIDD
 * 受害用户统计biz
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Service
public class UserAffectedBiz extends BaseBiz<UserAffectedMapper, UserAffected> {

    /**
     * 受害用户总人数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 总数
     */
    public int countAffectedByDate(@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countAffectedByDate(start, end);
    }

    /**
     * 按天统计各区域受害人数
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 各地区数目
     */
    public List<CityCodeQty> countAffectedByAreaAndDate(@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countAffectedByAreaAndDate(start, end);
    }

    /**
     * 受害类型占比
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 占比
     */
    public List<CommonQty> countTypeByDate(@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countTypeByDate(start, end);
    }

    /**
     * 通话次数TOP
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 次数top5
     */
    public List<MdnQty> countCallTimesByDate(@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countCallTimesByDate(start, end);
    }

    /**
     * 受害用户量趋势
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return 各时间个数
     */
    public List<DateQty> countAffectedByTimestamp(@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countAffectedByTimestamp(start, end);
    }

    /**
     * 按条件查询
     *
     * @param vo
     * @return
     */
    public TableResultResponse<UserAffected> queryByExampleAndPage(UserAffectedVo vo) {
        Example example = new Example(UserAffected.class);
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
            String fraudedMdn = vo.getFraudedMdn();
            if (StringUtils.isNotEmpty(fraudedMdn)) {
                isCriteria = true;
                criteria.andEqualTo("fraudedMdn", fraudedMdn);
            }

            String sourceId = vo.getSourceId();
            if (StringUtils.isNotEmpty(sourceId)) {
                isCriteria = true;
                criteria.andEqualTo("sourceId", sourceId);
            }

            String baseId = vo.getBaseId();
            if (StringUtils.isNotEmpty(baseId)) {
                isCriteria = true;
                criteria.andEqualTo("baseId", baseId);
            }

            String type = vo.getType();
            if (StringUtils.isNotEmpty(type)) {
                isCriteria = true;
                criteria.andEqualTo("type", type);
            }

            Date start = vo.getStartTime();
            Date end = vo.getEndTime();
            if (null != start && null != end) {
                isCriteria = true;
                criteria.andBetween("time", start, end);
            }

            Date occurTimeStart = vo.getOccurTimeStart();
            Date occurTimeEnd = vo.getOccurTimeEnd();
            if (null != occurTimeStart && null != occurTimeEnd) {
                isCriteria = true;
                criteria.andBetween("occurTime", occurTimeStart, occurTimeEnd);
            }

            page = vo.getPage();
            limit = vo.getLimit();
        }


        if (0 == page && 0 == limit) {
            page = 1;
            limit = 10;
        }

        Page<Object> result = PageHelper.startPage(page, limit);

        List<UserAffected> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
        } else {
            list = mapper.selectByExample(new Example(UserAffected.class));
        }

        return new TableResultResponse<>(result.getTotal(), list);
    }
}
