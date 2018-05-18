package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.MdnSuspStats;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 疑似号码统计 Mapper
 *
 * @author sunbin-71738
 * @date 2018-04-28
 */
public interface MdnSuspStatsMapper extends Mapper<MdnSuspStats> {

    /**
     * 高危区域按天 支持top
     *
     * @param start
     * @param end
     * @param index
     * @param size
     * @return
     */
    List<CityCodeQty> countAreaByDate(@Param("start") Integer start, @Param("end") Integer end
            , @Param("index") Integer index, @Param("size") Integer size);


    /**
     * 识别源占比
     *
     * @param start
     * @param end
     * @return
     */
    List<CommonQty> countSourceTypeByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  按日期计算总量
     * @param start
     * @param end
     * @return
     */
    int countMdnByDate(@Param("start") Integer start, @Param("end") Integer end);
}
