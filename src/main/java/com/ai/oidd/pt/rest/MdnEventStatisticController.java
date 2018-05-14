package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.MdnEventStatistic;
import com.ai.oidd.pt.service.IMdnEventStatisticService;
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
@RequestMapping("mesc")
@Api(value = "mdnEventStatisticController", tags = {"疑似号码统计操作接口"})
public class MdnEventStatisticController extends BaseController<IMdnEventStatisticService, MdnEventStatistic> {
}
