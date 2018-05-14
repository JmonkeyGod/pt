package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Data
@Table(name = "t_event_summary")
public class SummaryEvent implements Serializable {

    @Id
    private int date;
    @Column(name = "stCounts")
    private int stCounts;
    @Column(name = "svCounts")
    private int svCounts;
}
