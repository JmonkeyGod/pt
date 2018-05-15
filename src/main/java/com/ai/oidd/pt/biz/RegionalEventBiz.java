package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.RegionalEvent;
import com.ai.oidd.pt.mapper.RegionalEventMapper;
import com.ai.oidd.pt.vo.RegionEvents;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service
public class RegionalEventBiz extends BaseBiz<RegionalEventMapper, RegionalEvent> {

    public List<RegionalEvent> getRegionalEventByTime(Integer start, Integer end) {
        Example example = new Example(RegionalEvent.class);

        if(0 != start && 0!= end){
            Example.Criteria criteria = example.createCriteria();
            criteria.andBetween("date", start, end);
        }
        return mapper.selectByExample(example);
    }

    public List<RegionEvents> countRegionEventByDate(@Param("start") Integer start
            , @Param("end") Integer end) {
        return mapper.countRegionalEventByDate(start, end);
    }

}
