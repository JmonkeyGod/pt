package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Asiainfo-OIDD
 * 区域信息
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Data
@Table(name = "t_region_info")
public class RegionInfo {
    @Id
    @Column(name = "regionId")
    private String regionId;
    @Column(name = "regionName")
    private String regionName;
}
