package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.ReportCaseBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.ReportCase;
import com.ai.oidd.pt.service.IReportCaseService;
import com.ai.oidd.pt.vo.ReportCaseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-24
 */
@Controller
@RequestMapping("rcc")
@Api(value = "报案数据", tags = {"报案数据"},description = "rcc")
public class ReportCaseController extends BaseController<IReportCaseService,ReportCase > {

    @Autowired
    private ReportCaseBiz reportCaseBiz;

    @ApiOperation("报案数据复杂查询")
    @RequestMapping(value = "/qbeap", method = RequestMethod.POST)
    @ResponseBody
    public TableResultResponse<ReportCase> queryByExampleAndPage(
            @ApiParam("查询对象") @RequestBody ReportCaseVo reportCaseVo) {
        return reportCaseBiz.queryByExampleAndPage(reportCaseVo);
    }
}
