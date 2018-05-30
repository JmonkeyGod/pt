package com.ai.oidd.pt.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Data
public class MdnBehavor implements Serializable {
    /**
     * 行为类型
     */
    private String type;
    /**
     * 对端号码
     */
    private String oppoMdn;

    /**
     * 区域名称
     */
    private Date time;

}
