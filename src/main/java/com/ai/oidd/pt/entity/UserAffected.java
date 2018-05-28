package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 受害用户统计
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Data
@Table(name = "t_user_affected")
public class UserAffected implements Serializable {

    /**
     *  识别时间
     */
    private Date time;

    /**
     * 诈骗号码
     */
    private String mdn;

    /**
     *  受害号码
     */
    @Column(name ="fraudedMdn")
    private String fraudedMdn;

    /**
     *  来源地
     */
    @Column(name ="sourceId")
    private String sourceId;

    /**
     *  发生地
     */
    @Column(name ="baseId")
    private String baseId;

    /**
     *  类型
     */
    private String type;

    /**
     *  发生时间
     */
    @Column(name ="occurTime")
    private Date occurTime;
}
