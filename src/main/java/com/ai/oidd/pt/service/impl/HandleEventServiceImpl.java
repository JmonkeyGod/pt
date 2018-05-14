package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.HandleEvent;
import com.ai.oidd.pt.mapper.HandleEventMapper;
import com.ai.oidd.pt.service.IHandleEventService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service("handleEventService")
public class HandleEventServiceImpl extends BaseServiceImpl<HandleEventMapper, HandleEvent>
        implements IHandleEventService {
}
