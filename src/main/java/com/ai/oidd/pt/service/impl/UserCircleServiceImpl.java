package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.UserCircle;
import com.ai.oidd.pt.mapper.UserCircleMapper;
import com.ai.oidd.pt.service.IUserCircleService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 用户活动范围 service
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Service("userCircleService")
public class UserCircleServiceImpl extends BaseServiceImpl<UserCircleMapper,UserCircle>
    implements IUserCircleService {
}
