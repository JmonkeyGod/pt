package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.UserAffectedBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserAffected;
import com.ai.oidd.pt.service.IUserAffectedService;
import com.ai.oidd.pt.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 受害用户统计 controller
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Controller
@RequestMapping("uac")
@Api(value = "受害用户统计", tags = {"受害用户统计"}, description = "uac")
public class UserAffectedController extends BaseController<IUserAffectedService, UserAffected> {

    @Autowired
    private UserAffectedBiz userAffectedBiz;

    @ApiOperation("按日期计算受害总量")
    @RequestMapping(value = "/cabd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<Integer> countAffectedByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        ObjectRestResponse<Integer> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(userAffectedBiz.countAffectedByDate(start, end));

        return entityObjectRestResponse;
    }

    @ApiOperation("按天统计各区域受害人数")
    @RequestMapping(value = "/count/cabad", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countAffectedByAreaAndDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<CityCodeQty> codeQties = userAffectedBiz.countAffectedByAreaAndDate(start, end);
        return new TableResultResponse<>(codeQties.size(), codeQties);
    }

    @ApiOperation("受害类型占比")
    @RequestMapping(value = "/count/ctby", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CommonQty> countTypeByDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<CommonQty> commonQties = userAffectedBiz.countTypeByDate(start, end);
        return new TableResultResponse<>(commonQties.size(), commonQties);
    }


    @ApiOperation("通话次数top")
    @RequestMapping(value = "/count/cctbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<MdnQty> countCallTimesByDate(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<MdnQty> mdnQties = userAffectedBiz.countCallTimesByDate(start, end);
        return new TableResultResponse<>(mdnQties.size(), mdnQties);
    }

    @ApiOperation("受害用户量趋势")
    @RequestMapping(value = "/count/cabt", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<DateQty> countAffectedByTimestamp(@RequestParam(required = false) Integer start
            , @RequestParam(required = false) Integer end) {
        List<DateQty> dateQties = userAffectedBiz.countAffectedByTimestamp(start, end);
        return new TableResultResponse<>(dateQties.size(), dateQties);
    }

    @ApiOperation("疑似终端统计复杂查询")
    @RequestMapping(value = "/qbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<UserAffected> queryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody UserAffectedVo userAffectedVo) {
        return userAffectedBiz.queryByExampleAndPage(userAffectedVo);
    }

}
