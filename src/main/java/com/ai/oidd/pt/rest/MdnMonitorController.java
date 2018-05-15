package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.MdnMonitor;
import com.ai.oidd.pt.service.IMdnMonitorService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Controller
@RequestMapping("mmc")
@Api(value = "MdnMonitorController", tags = {"高危号码监测"})
public class MdnMonitorController extends BaseController<IMdnMonitorService, MdnMonitor> {
}
