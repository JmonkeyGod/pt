package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.TerminalSuspStatsBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.TerminalSuspStats;
import com.ai.oidd.pt.service.ITerminalSuspStatsService;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.TerminalSuspStatsHistoryVo;
import com.ai.oidd.pt.vo.TerminalSuspStatsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Asiainfo-OIDD
 * 疑似终端统计
 *
 * @author xieyy-66676
 * @date 2018-05-25
 */
@Controller
@RequestMapping("tssc")
@Api(value = "疑似终端统计", tags = {"疑似终端统计"}, description = "tssc")
public class TerminalSuspStatsController extends BaseController<ITerminalSuspStatsService, TerminalSuspStats>{

    @Autowired
    private TerminalSuspStatsBiz biz;

    @ApiOperation("终端按区域分布")
    @RequestMapping(value = "/cabd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countAreaByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return biz.countAreaByDate(start, end);
    }

    @ApiOperation("按日期计算总量")
    @RequestMapping(value = "/ctbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<Integer> countTerminalByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return biz.countTerminalByDate(start, end);
    }

    @ApiOperation("终端分布")
    @RequestMapping(value = "/cttbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CommonQty> countTerminalTypeByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return biz.countTerminalTypeByDate(start, end);
    }

    @ApiOperation("高危区域按天top10")
    @RequestMapping(value = "/ctabd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countTopAreaByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return biz.countTopAreaByDate(start, end);
    }

    @ApiOperation("疑似终端统计复杂查询")
    @RequestMapping(value = "/qbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<TerminalSuspStats> queryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody TerminalSuspStatsVo terminalSuspStatsVo) {
        return biz.queryByExampleAndPage(terminalSuspStatsVo);
    }


    @ApiOperation("终端历史")
    @RequestMapping(value = "/qhbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<TerminalSuspStats> queryHistoryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody TerminalSuspStatsHistoryVo terminalSuspStatsHistoryVo) {
        return biz.queryHistoryByExampleAndPage(terminalSuspStatsHistoryVo);
    }
}
