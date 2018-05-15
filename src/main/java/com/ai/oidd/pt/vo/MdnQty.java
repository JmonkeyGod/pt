package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 通信趋势
 * @author sunbin-71738
 * @date 2018-05-15
 * @see com.ai.oidd.pt.entity.UserCommQty
 */
@Data
public class MdnQty implements Serializable {

    /**
     * 用户号码
     */
    private int date;
    /**
     * 通话量
     */
    private int cms;
    /**
     * 短信量
     */
    private int sms;
}
