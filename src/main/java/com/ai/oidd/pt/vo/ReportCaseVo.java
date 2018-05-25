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
public class ReportCaseVo extends Query implements Serializable {

    /**
     * 报案开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 报案结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 诈骗号码
     */
    private String fraudMdn;

    /**
     * 受骗号码
     */
    private String fraudedMdn;

    /**
     * 诈骗类型
     */
    private String type;

    /**
     * 是否被骗
     */
    private String result;

    /**
     * 受骗金额
     */
    private String loss;

    /**
     * 发生开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date occurDateStart;

    /**
     * 发生结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date occurDateEnd;
}
