package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-18
 */
@Data
public class SourceTypeVo implements Serializable {
    private String sourceName;
    private int counts;
    private float ratio;
}
