package com.ai.oidd.pt.common.util;


import lombok.Data;

/**
 * Asiainfo-OIDD
 * 查询参数
 *
 * @author sunbin-71738
 * @date 2018-03-30
 */
@Data
public class Query {

    /**
     * 当前页码
     */
    int page = 1;
    /**
     * 每页条数
     */
    int limit = 10;

}
