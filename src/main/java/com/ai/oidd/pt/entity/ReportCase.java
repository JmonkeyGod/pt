package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 报案数据
 *
 * @author sunbin-71738
 * @date 2018-04-24
 */
@Data
@Table(name = "t_report_case")
public class ReportCase {

    @Id
    private int id;

    /**
     * 诈骗号码：07318893112
     */
    @Column(name = "fraudMdn")
    private String fraudMdn;

    /**
     * 被骗用户：1893696364
     */
    @Column(name = "fraudedMdn")
    private String fraudedMdn;

    /**
     * 诈骗类型：冒充银行
     */
    private String type;

    /**
     * 发生时间： 2018-03-23
     */
    @Column(name = "occurTime")
    private Date occurTime;

    /**
     * 报案时间：2018-03-23
     */
    @Column(name = "reportTime")
    private Date reportTime;

    /**
     * 受骗金额：19000
     */
    private double loss;

    /**
     * 是否被骗：是
     */
    private boolean result;

    /**
     * 主叫/被叫：主叫
     */
    @Column(name = "callType")
    private String callType;

    /**
     * 诈骗过程描述
     */
    private String description;
}
