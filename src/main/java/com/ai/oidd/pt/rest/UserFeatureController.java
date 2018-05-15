package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.biz.UserTerminalBiz;
import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.entity.UserFeature;
import com.ai.oidd.pt.entity.UserTerminal;
import com.ai.oidd.pt.service.IUserFeatureService;
import com.ai.oidd.pt.vo.UserFeatureVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Asiainfo-OIDD
 * 用户特征 controller
 *
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Controller
@RequestMapping("ufc")
@Api(value = "UserFeatureController", tags = {"用户特征"})
public class UserFeatureController extends BaseController<IUserFeatureService, UserFeature> {

    @Autowired
    private UserTerminalBiz userTerminalBiz;

    @ApiOperation("查询单个用户特征")
    @RequestMapping(value = "/{mdn}", method = RequestMethod.GET)
    @ResponseBody
    public ObjectRestResponse<UserFeature> get(@ApiParam("用户号码") @PathVariable String mdn) {
        ObjectRestResponse<UserFeature> entityObjectRestResponse = new ObjectRestResponse<>();

        UserFeature userFeature =  base.selectById(mdn);
        if(null != userFeature){
            UserFeatureVo featureVo = new UserFeatureVo();
            BeanUtils.copyProperties(userFeature,featureVo);
            UserTerminal userTerminal = userTerminalBiz.queryUserTerminal(mdn);
            String terminalType = userTerminal.getTerminalType();
            if (null != terminalType) {
                featureVo.setTerminalType(terminalType);
            }

            entityObjectRestResponse.data(featureVo);
        }else{
            entityObjectRestResponse.data(userFeature);
        }

        return entityObjectRestResponse;
    }
}
