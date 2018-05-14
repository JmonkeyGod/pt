package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.RegionInfo;
import com.ai.oidd.pt.mapper.RegionInfoMapper;
import com.ai.oidd.pt.service.IRegionInfoService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Service("regionInfoService")
public class RegionInfoServiceImpl extends BaseServiceImpl<RegionInfoMapper, RegionInfo>
        implements IRegionInfoService {
}
