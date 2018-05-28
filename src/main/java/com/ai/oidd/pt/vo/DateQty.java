package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Data
public class DateQty implements Serializable {
    private Date time;
    private int qty;
}
