package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.entity.ReportCase;
import com.ai.oidd.pt.mapper.ReportCaseMapper;
import com.ai.oidd.pt.service.IReportCaseService;
import org.springframework.stereotype.Service;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-24
 */
@Service("reportCaseService")
public class ReportCaseServiceImpl extends BaseServiceImpl<ReportCaseMapper,ReportCase>
        implements IReportCaseService {
}
