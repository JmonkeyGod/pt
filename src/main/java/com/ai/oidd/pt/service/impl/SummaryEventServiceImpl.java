package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.SummaryEvent;
import com.ai.oidd.pt.mapper.SummaryEventMapper;
import com.ai.oidd.pt.service.ISummaryEventService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service("summaryEventService")
public class SummaryEventServiceImpl extends BaseServiceImpl<SummaryEventMapper,SummaryEvent>
        implements ISummaryEventService {
}
