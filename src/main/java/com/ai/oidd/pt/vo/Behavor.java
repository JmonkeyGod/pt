package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Data
public class Behavor implements Serializable {
    /**
     * 行为类型
     */
    private String type;
    /**
     * 经纬度
     */
    private String position;

    /**
     * 区域名称
     */
    private String area;
}
