package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.SummaryEvent;
import com.ai.oidd.pt.mapper.SummaryEventMapper;
import com.ai.oidd.pt.vo.SummaryEvents;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-11
 */
@Service
public class SummaryEventBiz extends BaseBiz<SummaryEventMapper,SummaryEvent> {


    public List<SummaryEvents> countSummaryEventByDate(@Param("start") Integer start
            , @Param("end") Integer end) {
        List<SummaryEvents> summaryEvents = mapper.countSummaryEventByDate(start, end);
        System.out.println(summaryEvents);
        if(1== summaryEvents.size()){
            if(null == summaryEvents.get(0)){
                return new ArrayList<>();
            }
        }
        return summaryEvents;
    }

}
