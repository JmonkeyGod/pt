package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.ReportCase;
import com.ai.oidd.pt.service.IReportCaseService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-24
 */
@Controller
@RequestMapping("rcc")
@Api(value="reportCaseController",tags={"报案数据"})
public class ReportCaseController extends BaseController<IReportCaseService,ReportCase > {
}
