package com.ai.oidd.pt.vo;

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
public class UserAffectedReplayVo implements Serializable {

    /**
     * 时间
     */
    private int time;

    /**
     * 行为类型
     * 1、呼入号码 2、呼出号码 3、发送短信 4、收到短信
     *
     */
    //type=1
    private long callIn;
    //type=2
    private long callOut;
    //type=3
    private long smsSend;
    //type=4
    private long smsRec;

}
