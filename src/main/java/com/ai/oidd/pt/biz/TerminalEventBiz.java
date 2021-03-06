package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.TerminalEvent;
import com.ai.oidd.pt.mapper.TerminalEventMapper;
import com.ai.oidd.pt.vo.DailyTerEvents;
import com.ai.oidd.pt.vo.TotalTerEvents;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service
public class TerminalEventBiz extends BaseBiz<TerminalEventMapper, TerminalEvent> {

    public List<TotalTerEvents> countTerminalEventByDate(Integer start, Integer end) {
        return mapper.countTerminalEventByDate(start, end);
    }

    public List<DailyTerEvents> countTerminalEventDaily(Integer start, Integer end) {
        return mapper.countTerminalEventDaily(start, end);
    }


}
