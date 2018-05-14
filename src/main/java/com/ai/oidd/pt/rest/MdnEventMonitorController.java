package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.MdnEventMonitor;
import com.ai.oidd.pt.service.IMdnEventMonitorService;
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
@RequestMapping("memc")
@Api(value = "mdnEventMonitorController", tags = {"高危号码监测"})
public class MdnEventMonitorController extends BaseController<IMdnEventMonitorService, MdnEventMonitor> {
}
