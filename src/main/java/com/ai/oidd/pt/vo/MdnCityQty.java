package com.ai.oidd.pt.vo;

import lombok.Data;
import java.io.Serializable;

/**
 * Asiainfo-OIDD
 * 活跃范围
 * @author sunbin-71738
 * @date 2018-05-15
 * @see com.ai.oidd.pt.entity.UserCircle
 */
@Data
public class MdnCityQty implements Serializable {
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 活跃数据量
     */
    private int qty;
}
