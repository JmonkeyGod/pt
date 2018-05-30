package com.ai.oidd.pt.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class MdnTrackParams implements Serializable {
    private String mdn;

    /**
     * 开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
