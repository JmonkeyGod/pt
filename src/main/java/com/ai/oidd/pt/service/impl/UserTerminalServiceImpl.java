package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.UserTerminal;
import com.ai.oidd.pt.mapper.UserTerminalMapper;
import com.ai.oidd.pt.service.IUserTerminalService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 用户终端 service
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Service("userTerminalService")
public class UserTerminalServiceImpl extends BaseServiceImpl<UserTerminalMapper,UserTerminal>
        implements IUserTerminalService {
}
