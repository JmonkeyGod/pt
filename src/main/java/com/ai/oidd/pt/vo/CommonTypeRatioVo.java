package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-17
 */
@Data
public class CommonTypeRatioVo implements Serializable {
    private int call;
    private int sms;
    private int on;
}
