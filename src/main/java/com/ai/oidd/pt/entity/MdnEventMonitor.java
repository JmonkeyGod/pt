package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 高危号码监测
 * @author sunbin-71738
 * @date 2018-04-27
 */
@Data
public class MdnEventMonitor implements Serializable {


    @Id
    private int id;

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
     * 识别源
     */
    @Column(name ="sourceType")
    private String sourceType;

    /**
     * 识别地点
     */
    @Column(name ="sourceArea")
    private String sourceArea;

    /**
     * 归属地
     */
    @Column(name ="hcode")
    private String hcode;

    /**
     * 备注
     */
    private String note;
}
