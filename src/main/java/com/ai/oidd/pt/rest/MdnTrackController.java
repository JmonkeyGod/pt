package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.MdnTrackBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.entity.MdnTrack;
import com.ai.oidd.pt.service.IMdnTrackService;
import com.ai.oidd.pt.vo.MdnBehavorTrack;
import com.ai.oidd.pt.vo.MdnTrackParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Controller
@RequestMapping("mtc")
@Api(value = "疑似追踪.html", tags = {"疑似追踪.html"}, description = "mtc")
public class MdnTrackController extends BaseController<IMdnTrackService, MdnTrack> {

    @Autowired
    private MdnTrackBiz mdnTrackBiz;

    @ApiOperation("用户追踪")
    @RequestMapping(value = "/qmtbc", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<MdnBehavorTrack> queryMdnTrackByConditions( @ApiParam("查询对象") @RequestBody MdnTrackParams params) {
        return mdnTrackBiz.queryMdnTrackByConditions(params);
    }
}
