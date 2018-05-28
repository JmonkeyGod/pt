package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.MdnAbnMonitorBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.MdnAbnBehavor;
import com.ai.oidd.pt.entity.MdnAbnCityCount;
import com.ai.oidd.pt.entity.MdnAbnTypeCountByDay;
import com.ai.oidd.pt.entity.MdnMonitor;
import com.ai.oidd.pt.service.IMdnAbnormalBehavorService;
import com.ai.oidd.pt.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Controller
@RequestMapping("mabc")
@Api(value = "异常行为", tags = {"异常行为"},description = "mabc")
public class MdnAbnBehavorController extends BaseController<IMdnAbnormalBehavorService, MdnAbnBehavor> {

    @Autowired
    private MdnAbnMonitorBiz mdnAbnMonitorBiz;

    @ApiOperation("异常行为省份占比")
    @RequestMapping(value = "/prbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<CommonProRatioVo> provinceRatioByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnAbnMonitorBiz.provinceRatioByDate(start, end);
    }

    @ApiOperation("本省地市排行")
    @RequestMapping(value = "/ptbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<MdnAbnCityCount> provinceTopByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnAbnMonitorBiz.provinceTopByDate(start, end);
    }

    @ApiOperation("异常行为类型占比")
    @RequestMapping(value = "/trbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<CommonTypeRatioVo> typeRatioByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnAbnMonitorBiz.typeRatioByDate(start, end);
    }


    @ApiOperation("本省异常类型按天统计")
    @RequestMapping(value = "/tsbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CommonTypeRatioByDayVo> typeStaByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnAbnMonitorBiz.typeStaByDate(start, end);
    }


    @ApiOperation("异常行为复杂查询")
    @RequestMapping(value = "/qbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<MdnAbnBehavor> queryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody MdnAbnMonitorVo mdnAbnMonitorVo) {
        return mdnAbnMonitorBiz.queryAbnByExampleAndPage(mdnAbnMonitorVo);
    }


    @ApiOperation("异常行为类型占比")
    @RequestMapping(value = "/ttbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<CommonTypeTopVo> typeTopByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnAbnMonitorBiz.typeTopByDate(start, end);
    }




}
