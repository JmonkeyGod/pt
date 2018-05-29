package com.ai.oidd.pt.vo;

import com.ai.oidd.pt.common.util.Query;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 *
 * @author xieyy-71738
 * @date 2018-05-25
 */
@Data
public class TerminalSuspStatsHistoryVo extends Query implements Serializable {

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
     * 终端串号
     */
    private String imei;

    /**
     * 终端类型
     */
    private String terminalType;

    /**
     * 识别地点
     */
    private String sourceArea;

    /**
     * 最近活跃时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date activeDateStart;

    /**
     * 最近活跃时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date activeDateEnd;
}
