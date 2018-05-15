package com.ai.oidd.pt.vo;

import com.ai.oidd.pt.entity.UserFeature;
import lombok.Data;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-15
 */
@Data
public class UserFeatureVo extends UserFeature {

    /**
     * 终端类型
     */
    private String terminalType;
}
