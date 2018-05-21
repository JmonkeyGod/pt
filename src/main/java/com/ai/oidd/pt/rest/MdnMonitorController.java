package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.MdnMonitorBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.MdnMonitor;
import com.ai.oidd.pt.service.IMdnMonitorService;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonDateQty;
import com.ai.oidd.pt.vo.CommonRatioVo;
import com.ai.oidd.pt.vo.MdnMonitorVo;
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
@RequestMapping("mmc")
@Api(value = "高危号码监测", tags = {"高危号码监测"}, description = "mmc")
public class MdnMonitorController extends BaseController<IMdnMonitorService, MdnMonitor> {

    @Autowired
    private MdnMonitorBiz mdnMonitorBiz;

    @ApiOperation("高危终端占比")
    @RequestMapping(value = "/trbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<CommonRatioVo> terminalRatioByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnMonitorBiz.terminalRatioByDate(start, end);
    }

    @ApiOperation("高危终端按天")
    @RequestMapping(value = "/ctbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CommonDateQty> countTerminalByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnMonitorBiz.countTerminalByDate(start, end);
    }

    @ApiOperation("高危号码占比")
    @RequestMapping(value = "/mrbd", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<CommonRatioVo> mdnRatioByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnMonitorBiz.mdnRatioByDate(start, end);
    }

    @ApiOperation("高危号码按天")
    @RequestMapping(value = "/cmbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CommonDateQty> countMdnByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnMonitorBiz.countMdnByDate(start, end);
    }


    @ApiOperation("高危区域")
    @RequestMapping(value = "/crbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countAreaByDate(
            @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        return mdnMonitorBiz.countAreaByDate(start, end);
    }


    @ApiOperation("高危号码复杂查询")
    @RequestMapping(value = "/qbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<MdnMonitor> queryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody MdnMonitorVo mdnMonitorVo) {
        return mdnMonitorBiz.queryByExampleAndPage(mdnMonitorVo);
    }


}
