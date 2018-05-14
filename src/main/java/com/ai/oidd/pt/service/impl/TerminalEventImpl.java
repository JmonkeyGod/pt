package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.TerminalEvent;
import com.ai.oidd.pt.mapper.TerminalEventMapper;
import com.ai.oidd.pt.service.ITerminalEventService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service("terminalEventService")
public class TerminalEventImpl extends BaseServiceImpl<TerminalEventMapper, TerminalEvent>
        implements ITerminalEventService {
}
