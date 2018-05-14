package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-26
 */
@Data
public class DailyTerEvents implements Serializable {
    private String date;
    private String sm;
    private String cm;
}
