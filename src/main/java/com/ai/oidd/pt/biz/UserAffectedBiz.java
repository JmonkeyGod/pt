package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserAffected;
import com.ai.oidd.pt.mapper.UserAffectedMapper;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.DateQty;
import com.ai.oidd.pt.vo.MdnQty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

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
}
