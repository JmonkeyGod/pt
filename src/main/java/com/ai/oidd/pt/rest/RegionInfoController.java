package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.entity.RegionInfo;
import com.ai.oidd.pt.service.IRegionalEventService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Controller
@RequestMapping("ric")
@Api(value = "区域编码", tags = {"区域编码"},description = "api")
public class RegionInfoController extends BaseController<IRegionalEventService,RegionInfo> {
    //只提供增删改查操作
}
