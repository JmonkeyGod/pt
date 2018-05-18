package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.UserCircleBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserCircle;
import com.ai.oidd.pt.service.IUserCircleService;
import com.ai.oidd.pt.vo.CityCodeQty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 用户活动范围 controller
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Controller
@RequestMapping("ucc")
@Api(value = "用户活动范围", tags = {"用户活动范围"},description = "ucc")
public class UserCircleController extends BaseController<IUserCircleService,UserCircle> {

    @Autowired
    private UserCircleBiz userCircleBiz;

    @ApiOperation("用户活动范围 - 按照日期统计每天的活动范围量")
    @RequestMapping(value = "/cmcbcc", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CityCodeQty> countMdnCircleByCityCode(
            @ApiParam("用户号码") @RequestParam(required = false) String mdn
            ,@ApiParam("开始日期") @RequestParam(required = false) Integer start
            ,@ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        List<CityCodeQty> mdnCityQties = userCircleBiz.countMdnCircleByCityCode(mdn,start, end);
        return new TableResultResponse<>(mdnCityQties.size(),mdnCityQties);
    }

}
