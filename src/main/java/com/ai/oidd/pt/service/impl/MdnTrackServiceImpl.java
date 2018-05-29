package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.MdnTrack;
import com.ai.oidd.pt.mapper.MdnTrackMapper;
import com.ai.oidd.pt.service.IMdnTrackService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 * 疑似追踪
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Service("mdnTrackService")
public class MdnTrackServiceImpl extends BaseServiceImpl<MdnTrackMapper,MdnTrack>
        implements IMdnTrackService {
}
