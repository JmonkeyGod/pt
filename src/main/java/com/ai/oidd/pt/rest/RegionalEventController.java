package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.RegionalEventBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.RegionalEvent;
import com.ai.oidd.pt.service.IRegionalEventService;
import com.ai.oidd.pt.vo.RegionEvents;
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
@RequestMapping("rec")
@Api(value = "regionalEventController",  tags = {"高危区域分析"})
public class RegionalEventController extends BaseController<IRegionalEventService, RegionalEvent> {

    @Autowired
    private RegionalEventBiz regionalEventBiz;

    @ApiOperation("高危区域-累计统计")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<RegionalEvent> listByDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        if(null == start || null == end){
            start = 0;
            end = 0;
        }
        List<RegionalEvent> regionalEvents = regionalEventBiz.getRegionalEventByTime(start, end);
        return new TableResultResponse<>(regionalEvents.size(), regionalEvents);
    }

    @ApiOperation("高危区域-按天统计")
    @RequestMapping(value = "/count/re", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<RegionEvents> countRegionEventByDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<RegionEvents> regionEvents = regionalEventBiz.countRegionEventByDate(start, end);
        return new TableResultResponse<>(regionEvents.size(), regionEvents);
    }

}
