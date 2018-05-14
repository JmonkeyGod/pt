package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.TerminalEvent;
import com.ai.oidd.pt.vo.DailyTerEvents;
import com.ai.oidd.pt.vo.TotalTerEvents;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
public interface TerminalEventMapper extends Mapper<TerminalEvent> {


    List<TotalTerEvents> countTerminalEventByDate(@Param("start") Integer start, @Param("end") Integer end);


    List<DailyTerEvents> countTerminalEventDaily(@Param("start") Integer start, @Param("end") Integer end);
}
