package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 异常行为
 * @author sunbin-71738
 * @date 2018-04-27
 */
@Data
public class MdnAbnCityCount implements Serializable {
    /**
     * code
     */
    private String code;

    /**
     * name
     */
    private String name;
    /**
     * total
     */
    private int total;
}
