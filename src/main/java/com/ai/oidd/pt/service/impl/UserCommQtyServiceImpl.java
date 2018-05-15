package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.UserCommQty;
import com.ai.oidd.pt.mapper.UserCommQtyMapper;
import com.ai.oidd.pt.service.IUserCommQtyService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 用户通讯量 service
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Service("userCommQtyService")
public class UserCommQtyServiceImpl extends BaseServiceImpl<UserCommQtyMapper,UserCommQty>
        implements IUserCommQtyService {
}
