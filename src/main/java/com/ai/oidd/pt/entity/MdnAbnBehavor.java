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
    @Column(name ="mdn")
    private String mdn;

    /**
     * 归属地
     */
    @Column(name ="hcode")
    private String hcode;

    /**
     * 异常类型
     */
    @Column(name ="type")
    private String type;

    /**
     *  异常量
     */
    @Column(name ="counts")
    private int counts;

    /**
     * 处理状态
     */
    @Column(name ="status")
    private int status;

    /**
     *  发生时间
     */
    @Column(name ="starttime")
    private Date starttime;

    /**
     *  结束时间
     */
    @Column(name ="lasttime")
    private Date lasttime;

}
