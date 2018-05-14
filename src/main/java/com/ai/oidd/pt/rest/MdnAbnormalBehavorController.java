package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.MdnAbnormalBehavor;
import com.ai.oidd.pt.service.IMdnAbnormalBehavorService;
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
@RequestMapping("mabc")
@Api(value = "mdnAbnormalBehavorController", tags = {"异常行为操作接口"})
public class MdnAbnormalBehavorController extends BaseController<IMdnAbnormalBehavorService, MdnAbnormalBehavor> {
}
