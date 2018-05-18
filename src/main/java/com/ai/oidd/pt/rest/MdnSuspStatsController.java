package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.MdnSuspStatsBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.MdnSuspStats;
import com.ai.oidd.pt.service.IMdnSuspStatsService;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.MdnSuspStatsVo;
import com.ai.oidd.pt.vo.SourceTypeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Asiainfo-OIDD
 * 疑似号码统计 controller
 *
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Controller
@RequestMapping("mssc")
@Api(value = "疑似号码统计", tags = {"疑似号码统计"}, description = "mssc")
public class MdnSuspStatsController extends BaseController<IMdnSuspStatsService, MdnSuspStats> {

    @Autowired
    private MdnSuspStatsBiz mdnSuspStatsBiz;

    @ApiOperation("识别源占比")
    @RequestMapping(value = "/strbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<SourceTypeVo> sourceTypeRatioByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnSuspStatsBiz.sourceTypeRatioByDate(start, end);
    }

    @ApiOperation("高危区域按天")
    @RequestMapping(value = "/cabd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countAreaByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnSuspStatsBiz.countAreaByDate(start, end);
    }

    @ApiOperation("高危区域按天top10")
    @RequestMapping(value = "/ctabd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countTopAreaByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnSuspStatsBiz.countTopAreaByDate(start, end);
    }

    @ApiOperation("疑似号码统计复杂查询")
    @RequestMapping(value = "/qbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<MdnSuspStats> queryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody MdnSuspStatsVo mdnSuspStatsVo) {
        return mdnSuspStatsBiz.queryByExampleAndPage(mdnSuspStatsVo);
    }

    @ApiOperation("按日期计算总量")
    @RequestMapping(value = "/cmbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<Integer> countMdnByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnSuspStatsBiz.countMdnByDate(start, end);
    }

}
