package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.MdnSuspStats;
import com.ai.oidd.pt.service.IMdnSuspStatsService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Asiainfo-OIDD
 * 疑似号码统计 controller
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Controller
@RequestMapping("mssc")
@Api(value = "MdnSuspectedStatsController", tags = {"疑似号码统计操作接口"})
public class MdnSuspStatsController extends BaseController<IMdnSuspStatsService, MdnSuspStats> {
}
