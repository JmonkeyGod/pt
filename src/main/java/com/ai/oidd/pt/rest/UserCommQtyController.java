package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.UserCommQtyBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserCommQty;
import com.ai.oidd.pt.service.IUserCommQtyService;
import com.ai.oidd.pt.vo.MdnDateQty;
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
 * 用户通讯量 controller
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Controller
@RequestMapping("ucqc")
@Api(value = "用户通讯量", tags = {"用户通讯量"},description = "ucqc")
public class UserCommQtyController extends BaseController<IUserCommQtyService,UserCommQty> {

    @Autowired
    private UserCommQtyBiz userCommQtyBiz;

    @ApiOperation("用户通讯量 - 按日期统计每天的通讯量")
    @RequestMapping(value = "/cmqbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<MdnDateQty> countMdnQtyByDate(
            @ApiParam("用户号码") @RequestParam(required = false) String mdn
            ,@ApiParam("开始日期")@RequestParam(required = false) Integer start
            ,@ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        List<MdnDateQty> mdnQties = userCommQtyBiz.countMdnQtyByDate(mdn,start, end);
        return new TableResultResponse<>(mdnQties.size(),mdnQties);
    }
}
