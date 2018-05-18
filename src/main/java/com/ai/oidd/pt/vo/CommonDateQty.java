package com.ai.oidd.pt.vo;

import lombok.Data;

/**
 * Asiainfo-OIDD
 * 终端历史
 * @author sunbin-71738
 * @date 2018-05-15
 * @see com.ai.oidd.pt.entity.UserTerminal
 */
@Data
public class CommonDateQty {
    /**
     * 日期
     */
    private int date;
    /**
     * 终端数据量
     */
    private int qty;
}
