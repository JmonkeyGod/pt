package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.MdnMonitor;
import com.ai.oidd.pt.mapper.MdnMonitorMapper;
import com.ai.oidd.pt.service.IMdnMonitorService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Service("mdnMonitorService")
public class MdnMonitorServiceImpl extends BaseServiceImpl<MdnMonitorMapper,MdnMonitor>
        implements IMdnMonitorService {
}
