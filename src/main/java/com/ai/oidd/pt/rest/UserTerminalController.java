package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.UserTerminalBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserTerminal;
import com.ai.oidd.pt.service.IUserTerminalService;
import com.ai.oidd.pt.vo.MdnTerQty;
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
 * 用户终端 controller
 *
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Controller
@RequestMapping("utc")
@Api(value = "UserTerminalController", tags = {"用户终端"})
public class UserTerminalController extends BaseController<IUserTerminalService, UserTerminal> {

    @Autowired
    private UserTerminalBiz userTerminalBiz;

    @ApiOperation("用户终端 - 按日期统计每天的终端量")
    @RequestMapping(value = "/ctqbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<MdnTerQty> countTerQtyByDate(
             @ApiParam("用户号码") @RequestParam(required = false) String mdn
            , @ApiParam("开始日期") @RequestParam(required = false) Integer start
            , @ApiParam("结束日期") @RequestParam(required = false) Integer end) {
        List<MdnTerQty> mdnTerQties = userTerminalBiz.countTerQtyByDate(mdn,start, end);
        return new TableResultResponse<>(mdnTerQties.size(), mdnTerQties);
    }
}
