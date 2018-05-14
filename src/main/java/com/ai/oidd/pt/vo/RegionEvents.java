package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-11
 */
@Data
public class RegionEvents implements Serializable {

    String regionId;
    String regionName;
    int counts;
}
