package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.RegionalEvent;
import com.ai.oidd.pt.mapper.RegionalEventMapper;
import com.ai.oidd.pt.service.IRegionalEventService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service("regionalEventService")
public class RegionalEventServiceImpl extends BaseServiceImpl<RegionalEventMapper, RegionalEvent>
        implements IRegionalEventService {
}
