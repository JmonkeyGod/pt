package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.SummaryEventBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.SummaryEvent;
import com.ai.oidd.pt.service.ISummaryEventService;
import com.ai.oidd.pt.vo.SummaryEvents;
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
@RequestMapping("sec")
@Api(value = "疑似欺诈、疑似受害", tags = {"疑似欺诈、疑似受害"},description = "api")
public class SummaryEventController extends BaseController<ISummaryEventService,SummaryEvent> {

    @Autowired
    private SummaryEventBiz summaryEventBiz;

    @ApiOperation("总览 - 疑似欺诈 疑似受害")
    @RequestMapping(value = "/count/se", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<SummaryEvents> countRegionEventByDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<SummaryEvents> regionEvents = summaryEventBiz.countSummaryEventByDate(start, end);
        return new TableResultResponse<>(regionEvents.size(), regionEvents);
    }

}
