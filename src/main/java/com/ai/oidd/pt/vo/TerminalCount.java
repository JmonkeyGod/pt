package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 疑似终端统计
 * Asiainfo-OIDD
 *
 * @author xieyy-66676
 * @date 2018-05-29
 */
@Data
public class TerminalCount implements Serializable {

    private String imei;

    private int total;
}
