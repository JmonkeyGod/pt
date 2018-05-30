package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 * 诈骗回放
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Data
public class UserAffectedReplay implements Serializable {

    /**
     * 时间
     */

    private int time;


    /**
     * 行为类型
     * 1、呼入号码 2、呼出号码 3、收到短信 4、发送短信
     *
     */
    private String type;

    /**
     * 时长
     */
    private long total;
}
