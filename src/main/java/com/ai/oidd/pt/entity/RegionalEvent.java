package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 区域事件
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Data
@Table(name = "t_event_regional")
public class RegionalEvent implements Serializable {

    @Id
    private int id;
    @Column(name = "regionId")
    private String regionId;
    @Column(name = "eventType")
    private String eventType;
    @Column(name = "eventCounts")
    private String eventCounts;
    private int date;
}
