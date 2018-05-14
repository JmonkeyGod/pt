package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.HandleEventBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.HandleEvent;
import com.ai.oidd.pt.service.IHandleEventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("hec")
@Api(value = "HandleEventController", tags = {"疑似号码发现&关停"})
public class HandleEventController extends BaseController<IHandleEventService, HandleEvent> {

    @Autowired
    private HandleEventBiz handleEventBiz;

    @ApiOperation("疑似号码发现&关停列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<HandleEvent> listByDate(@ApiParam("开始时间") @RequestParam(required = false) Integer start
            ,@ApiParam("结束时间") @RequestParam(required = false) Integer end) {
        if(null == start || null==end){
            start=0;
            end=0;
        }
        List<HandleEvent> handleEvents = handleEventBiz.getHandleEventByTime(start, end);
        return new TableResultResponse<>(handleEvents.size(), handleEvents);
    }
}
