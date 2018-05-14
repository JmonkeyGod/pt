package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * Asiainfo-OIDD
 * 终端事件
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Data
@Table(name = "t_event_terminal")
public class TerminalEvent implements Serializable {

    @Id
    private int id;
    private String mdn;
    private String cmap;
    private String mm;
    private String sm;
    private String cm;
    @Column(name ="updateTime")
    private Date updateTime;

}
