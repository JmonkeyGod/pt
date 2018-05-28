package com.ai.oidd.pt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 异常行为
 * @author sunbin-71738
 * @date 2018-04-27
 */
@Data
public class MdnAbnTypeTop implements Serializable {
    /**
     * mdn
     */
    private String mdn;

    /**
     * total
     */
    private int total;
}
