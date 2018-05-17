package com.ai.oidd.pt.vo;

import com.ai.oidd.pt.common.util.Query;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-17
 */
@Data
public class MdnSuspStatsVo extends Query implements Serializable {

    /**
     * 识别结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 识别结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 疑似号码
     */
    private String mdn;

    /**
     * 识别源
     */
    private String sourceType;

    /**
     * 识别地点
     */
    private String sourceArea;

    /**
     * 归属地
     */
    private String baseId;

    /**
     * 最近活跃时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastDateStart;

    /**
     * 最近活跃时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastDateEnd;

    /**
     * 活跃度
     */
    private float activeness;
}
