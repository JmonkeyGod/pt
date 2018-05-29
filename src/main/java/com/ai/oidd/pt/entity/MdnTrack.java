package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Data
@Table(name = "t_event_track")
public class MdnTrack implements Serializable {

    private Date time;

    private String mdn;

    @Column(name = "oppoMdn")
    private String oppoMdn;

    private String type;

    @Column(name = "terminalType")
    private String terminalType;

    private String position;

    private String area;
}
