package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Data
public class MdnQty implements Serializable {

    private String mdn;
    private int qty;
}
