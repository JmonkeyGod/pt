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
 * @date 2018-05-15
 */
@Data
public class MdnAbnMonitorVo extends Query implements Serializable {
    /**
     * 识别结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date starttime;

    /**
     * 识别结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lasttime;

    /**
     * 号码
     */
    private String mdn;

    /**
     * 异常类型
     */
    private String type;

    /**
     * 异常状态
     */
    private String status;

    /**
     * 归属地
     */
    private String hcode;

}
