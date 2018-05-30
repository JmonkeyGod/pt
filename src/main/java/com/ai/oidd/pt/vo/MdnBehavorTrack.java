package com.ai.oidd.pt.vo;

import lombok.Data;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 终端行为追踪
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Data
public class MdnBehavorTrack {
    private String mdn;
    private List<MdnPosition> positions;
    private List<MdnBehavor> behavors;
}
