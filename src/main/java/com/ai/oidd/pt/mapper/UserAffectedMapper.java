package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.UserAffected;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.DateQty;
import com.ai.oidd.pt.vo.MdnQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 受害用户统计Mapper
 * @author sunbin-71738
 * @date 2018-05-28
 */

public interface UserAffectedMapper extends Mapper<UserAffected> {

    /**
     * 受害用户总人数
     * @param start 开始时间
     * @param end 结束时间
     * @return 总数
     */
    int countAffectedByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  按天统计各区域受害人数
     * @param start 开始时间
     * @param end 结束时间
     * @return 各地区数目
     */
    List<CityCodeQty> countAffectedByAreaAndDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  受害类型占比
     * @param start 开始时间
     * @param end 结束时间
     * @return 占比
     */
    List<CommonQty> countTypeByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * 通话次数TOP
     * @param start 开始时间
     * @param end 结束时间
     * @return 次数top5
     */
    List<MdnQty> countCallTimesByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  受害用户量趋势
     * @param start 开始时间
     * @param end 结束时间
     * @return 各时间个数
     */
    List<DateQty> countAffectedByTimestamp(@Param("start") Integer start, @Param("end") Integer end);


}
