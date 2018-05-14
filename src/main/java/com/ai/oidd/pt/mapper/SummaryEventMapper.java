package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.SummaryEvent;
import com.ai.oidd.pt.vo.SummaryEvents;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
public interface SummaryEventMapper extends Mapper<SummaryEvent> {

    /**
     *  统计总数
     * @param start
     * @param end
     * @return
     */
    List<SummaryEvents> countSummaryEventByDate(@Param("start") Integer start, @Param("end") Integer end);
}
