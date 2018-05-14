package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.MdnEventMonitor;
import com.ai.oidd.pt.mapper.MdnEventMonitorMapper;
import com.ai.oidd.pt.service.IMdnEventMonitorService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Service("mdnEventMonitorService")
public class MdnEventMonitorServiceImpl extends BaseServiceImpl<MdnEventMonitorMapper,MdnEventMonitor>
        implements IMdnEventMonitorService {
}
