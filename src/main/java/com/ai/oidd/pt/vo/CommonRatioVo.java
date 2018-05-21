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
public class CommonRatioVo implements Serializable {
    private String name;
    private int qty;
    private float ratio;
    private String percent;
}
