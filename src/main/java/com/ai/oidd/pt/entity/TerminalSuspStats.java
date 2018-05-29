package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @Column(name ="terminalType")
    private String terminalType;

    /**
     * 识别地点
     */
    @Column(name ="sourceArea")
    private String sourceArea;

    /**
     * 归属地
     */
    @Column(name ="baseId")
    private String baseId;

    /**
     * 活跃时间
     */
    @Column(name ="activeDate")
    private Date activeDate;

    /**
     * 活跃度
     */
    @Column(name ="activeness")
    private float activeness;

    /**
     * 备注
     */
    private String note;

    /**
     * 出现次数
     */
    @Transient
    private int appearNum;
}
