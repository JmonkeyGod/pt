package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 用户通讯量
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Data
@Table(name = "t_user_commQty")
public class UserCommQty implements Serializable {
    /**
     *  用户号码
     */
    private String mdn;
    /**
     *  日期
     */
    private String date;
    /**
     *  主叫数量
     */
    @Column(name = "callingNum")
    private int callingNum;
    /**
     *  被叫数量
     */
    @Column(name = "calledNum")
    private int calledNum;
    /**
     *  短信发数量
     */
    @Column(name = "mailingNum")
    private int mailingNum;
    /**
     *  短信收数量
     */
    @Column(name = "mailedNum")
    private int mailedNum;
    /**
     *  备注
     */
    private String note;

}
