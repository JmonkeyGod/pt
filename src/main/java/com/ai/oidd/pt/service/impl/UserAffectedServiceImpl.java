package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.UserAffected;
import com.ai.oidd.pt.mapper.UserAffectedMapper;
import com.ai.oidd.pt.service.IUserAffectedService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 受害用户统计 service
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Service("userAffectedService")
public class UserAffectedServiceImpl extends BaseServiceImpl<UserAffectedMapper,UserAffected> implements IUserAffectedService {
}
