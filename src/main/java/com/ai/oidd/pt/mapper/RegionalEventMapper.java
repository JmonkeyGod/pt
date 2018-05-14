package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.RegionalEvent;
import com.ai.oidd.pt.vo.RegionEvents;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
public interface RegionalEventMapper extends Mapper<RegionalEvent> {

    /**
     *  统计总数
     * @param start
     * @param end
     * @return
     */
    List<RegionEvents> countRegionalEventByDate(@Param("start") Integer start,@Param("end") Integer end);
}
