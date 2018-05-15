package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.MdnSuspStats;
import com.ai.oidd.pt.mapper.MdnSuspStatsMapper;
import com.ai.oidd.pt.service.IMdnSuspStatsService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 疑似号码统计 service
 * @author sunbin-71738
 * @date 2018-04-28
 */
@Service("mdnSuspStatsService")
public class MdnSuspStatsServiceImpl extends BaseServiceImpl<MdnSuspStatsMapper, MdnSuspStats>
        implements IMdnSuspStatsService {
}
