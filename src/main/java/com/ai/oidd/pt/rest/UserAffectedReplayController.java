package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.UserAffectedReplayBiz;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserAffectedReplay;
import com.ai.oidd.pt.service.IUserAffectedReplayService;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.MdnQty;
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
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Controller
@RequestMapping("uarc")
@Api(value = "诈骗回放", tags = {"诈骗回放"}, description = "uarc")
public class UserAffectedReplayController extends BaseController<IUserAffectedReplayService,UserAffectedReplay> {

    @Autowired
    private UserAffectedReplayBiz userAffectedReplayBiz;

    @ApiOperation("通话时长top5")
    @RequestMapping(value = "/count/cdbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<MdnQty> countDurationByDate(@ApiParam("开始日期") @RequestParam(required = false) Integer start
            ,@ApiParam("结束日期")  @RequestParam(required = false) Integer end) {
        List<MdnQty> mdnQties = userAffectedReplayBiz.countDurationByDate(start, end);
        return new TableResultResponse<>(mdnQties.size(), mdnQties);
    }

    @ApiOperation("诈骗回放")
    @RequestMapping(value = "/count/cmtbd", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<CommonQty> countMdnTypeByDate(@RequestParam String mdn
            ,@ApiParam("开始日期")  @RequestParam(required = false) Integer start
            ,@ApiParam("结束日期")  @RequestParam(required = false) Integer end) {
        List<CommonQty> commonQties = userAffectedReplayBiz.countMdnTypeByDate(mdn,start, end);
        return new TableResultResponse<>(commonQties.size(), commonQties);
    }


}