package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 疑似终端统计
 * @author xieyy-66676
 * @date 2018-05-25
 */
@Data
@Table(name = "t_terminal_suspstats")
public class TerminalSuspStats implements Serializable {

    /**
     * 识别时间
     */
    private Date time;

    /**
     * 疑似号码
     */
    private String mdn;

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
     * 归属地
     */
    private String baseId;

    /**
     * 活跃时间
     */
    private Date activeDate;

    /**
     * 活跃度
     */
    private float activeness;

    /**
     * 备注
     */
    private String note;
}
