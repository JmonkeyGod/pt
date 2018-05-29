package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.TerminalSuspStats;
import com.ai.oidd.pt.mapper.TerminalSuspStatsMapper;
import com.ai.oidd.pt.service.BaseService;
import com.ai.oidd.pt.service.ITerminalEventService;
import com.ai.oidd.pt.service.ITerminalSuspStatsService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 疑似终端统计
 *
 * @author xieyy-66676
 * @date 2018-05-25
 */
@Service("terminalSuspStatsService")
public class TerminalSuspStatsServiceImpl extends BaseServiceImpl<TerminalSuspStatsMapper, TerminalSuspStats>
        implements ITerminalSuspStatsService{
}
