package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 异常行为
 * @author sunbin-71738
 * @date 2018-04-27
 */
@Data
@Table(name="t_mdn_abn_behavor")
public class MdnAbnBehavor implements Serializable {
    /**
     * 疑似号码
     */
    private String mdn;

    /**
     * 归属地
     */
    @Column(name ="baseId")
    private String baseId;

    /**
     * 异常类型
     */
    private String type;

    /**
     *  异常量
     */
    @Column(name ="counts")
    private int counts;

    /**
     * 处理状态
     */
    private int status;

    /**
     *  发生时间
     */
    @Column(name ="startTime")
    private Date startTime;

    /**
     *  报案时间
     */
    @Column(name ="caseTime")
    private Date caseTime;

    /**
     *  操作
     */
    private String operation;
}
