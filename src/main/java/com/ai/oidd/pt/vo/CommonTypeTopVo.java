package com.ai.oidd.pt.vo;

import com.ai.oidd.pt.entity.MdnAbnTypeTop;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-17
 */
@Data
public class CommonTypeTopVo implements Serializable {
    private List<MdnAbnTypeTop> callData;
    private List<MdnAbnTypeTop> smsData;
    private List<MdnAbnTypeTop> onData;
}
