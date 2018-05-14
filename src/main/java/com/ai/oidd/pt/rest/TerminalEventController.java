package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.TerminalEventBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.TerminalEvent;
import com.ai.oidd.pt.service.ITerminalEventService;
import com.ai.oidd.pt.vo.DailyTerEvents;
import com.ai.oidd.pt.vo.TotalTerEvents;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Controller
@RequestMapping("tec")
@Api(value = "terminalEventController", tags = {"高危终端"})
public class TerminalEventController extends BaseController<ITerminalEventService, TerminalEvent> {

    @Autowired
    private TerminalEventBiz terminalEventBiz;

    @ApiOperation("高危终端 - 累计高危终端数")
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<TotalTerEvents> countTerminalEventByDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<TotalTerEvents> totalTerEvents = terminalEventBiz.countTerminalEventByDate(start, end);
        return new TableResultResponse<>(totalTerEvents.size(),totalTerEvents);
    }

    @ApiOperation("总览 - 高频呼出，短信，总量")
    @RequestMapping(value = "/count/te", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DailyTerEvents> countTerminalEventDaily(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<DailyTerEvents> terminalEvents = terminalEventBiz.countTerminalEventDaily(start, end);
        return new TableResultResponse<>(terminalEvents.size(), terminalEvents);
    }
}
