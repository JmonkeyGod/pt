package com.ai.oidd.pt.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 用户特征
 * @author sunbin-71738
 * @date 2018-05-14
 */
@Data
@Table(name = "t_user_feature")
public class UserFeature implements Serializable {
    /**
     * 用户号码
     */
    @Id
    private String mdn;

    /**
     * 平衡性
     */
    private float balance;
    /**
     * 活跃度
     */
    @Column(name = "activeness")
    private float activeness;
    /**
     * 稳定性
     */
    private float stability;
    /**
     * 交际圈
     */
    @Column(name = "socialCircle")
    private float socialCircle;
    /**
     * 归属地
     */
    @Column(name = "baseId")
    private String baseId;
    /**
     * 常驻地
     */
    @Column(name = "permArea")
    private String permArea;
    /**
     * 活跃时段
     */
    @Column(name = "aperiod")
    private String aperiod;
    /**
     * 市际漫游个数
     */
    @Column(name = "croams")
    private String croams;
    /**
     * 市际漫游时长
     */
    @Column(name = "croamDu")
    private long croamDu;
    /**
     * 省际漫游个数
     */
    @Column(name = "proams")
    private String proams;
    /**
     * 省际漫游时长
     */
    @Column(name = "proamDu")
    private long proamDu;

}
