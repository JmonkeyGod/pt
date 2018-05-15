package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 用户活动范围
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Data
@Table(name = "t_user_circle")
public class UserCircle implements Serializable {
    /**
     *  用户号码
     */
    private String mdn;
    /**
     *  时间
     */
    private int date;
    /**
     *  城市编码
     */
    @Column(name = "cityCode")
    private String cityCode;
    /**
     *  备注
     */
    private String note;
}
