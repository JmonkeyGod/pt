package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 用户终端
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Data
@Table(name = "t_user_terminal")
public class UserTerminal implements Serializable {
    /**
     * 用户号码
     */
    private String mdn;
    /**
     * 时间
     */
    private String time;
    /**
     * 终端串号
     */
    private String imei;
    /**
     * 终端类型
     */
    @Column(name = "terminalType")
    private String terminalType;
    /**
     * 备注
     */
    private String note;
}
