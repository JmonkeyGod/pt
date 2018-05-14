package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 累计终端统计
 * @author sunbin-71738
 * @date 2018-04-24
 */
@Data
public class TotalTerEvents implements Serializable {

    /**
     * 统计时间
     */
    private String date;

    /**
     * 总数
     */
    private int total;
}
