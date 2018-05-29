package com.ai.oidd.pt.vo;

import com.ai.oidd.pt.common.util.Query;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-17
 */
@Data
public class UserAffectedVo extends Query implements Serializable {

    /**
     * 开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 识别结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 诈骗号码
     */
    private String mdn;

    /**
     * 来源地
     */
    private String sourceId;


    /**
     * 发生地
     */
    private String baseId;


    /**
     * 类型
     */
    private String type;

    /**
     * 发生时间开始
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date occurTimeStart;

    /**
     * 发生时间结束
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date occurTimeEnd;

}
