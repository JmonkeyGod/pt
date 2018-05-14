package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Asiainfo-OIDD
 * 疑似号码发现&关停
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Data
@Table(name ="t_event_handle")
public class HandleEvent {
    @Id
    private int date;
    @Column(name = "confirmCounts")
    private int confirmCounts;
    @Column(name = "handleCounts")
    private int handleCounts;
}
