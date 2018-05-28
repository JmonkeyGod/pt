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
public class MdnAbnTypeCountByDay implements Serializable {
    private int date;
    /**
     * type
     */
    private String type;

    /**
     * total
     */
    private int total;
}
