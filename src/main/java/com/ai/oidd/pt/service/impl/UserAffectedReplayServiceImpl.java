package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.UserAffectedReplay;
import com.ai.oidd.pt.mapper.UserAffectedReplayMapper;
import com.ai.oidd.pt.service.IUserAffectedReplayService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 诈骗回放 service
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Service("userAffectedReplayService")
public class UserAffectedReplayServiceImpl extends BaseServiceImpl<UserAffectedReplayMapper, UserAffectedReplay>
        implements IUserAffectedReplayService {
}
