package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.UserFeature;
import com.ai.oidd.pt.mapper.UserFeatureMapper;
import com.ai.oidd.pt.service.IUserFeatureService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 用户特征 service
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Service("userFeatureService")
public class UserFeatureServiceImpl extends BaseServiceImpl<UserFeatureMapper,UserFeature>
        implements IUserFeatureService {
}
