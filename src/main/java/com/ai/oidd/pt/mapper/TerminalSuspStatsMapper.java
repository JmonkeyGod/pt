package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.TerminalSuspStats;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.TerminalCount;
import com.ai.oidd.pt.vo.TerminalSuspStatsVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 疑似号码统计 Mapper
 *
 * @author xieyy-66676
 * @date 2018-05-25
 */
public interface TerminalSuspStatsMapper extends Mapper<TerminalSuspStats> {

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
     * 终端类型分布
     *
     * @param start
     * @param end
     * @return
     */
    List<CommonQty> countTerminalTypeByDate(@Param("start") Integer start, @Param("end") Integer end);


    /**
     *  按日期计算总量
     * @param start
     * @param end
     * @return
     */
    int countTerminalByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * 按条件查询终端串号 group by imei
     * @param vo
     * @return
     */
    List<TerminalCount> countTerminalImei(@Param("vo") TerminalSuspStatsVo vo);

    /**
     * imei最早识别时间
     * @param vo
     * @param imei
     * @return
     */
    TerminalSuspStats queryMinTime(@Param("vo") TerminalSuspStatsVo vo, @Param("imei") String imei);

    /**
     * imei最新活动时间
     * @param vo
     * @param imei
     * @return
     */
    TerminalSuspStats queryMaxActiveTime(@Param("vo") TerminalSuspStatsVo vo, @Param("imei") String imei);
}
