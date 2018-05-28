package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.UserAffected;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * Asiainfo-OIDD
 * 受害用户统计 Mapper
 * @author sunbin-71738
 * @date 2018-05-28
 */

public interface UserAffectedMapper extends Mapper<UserAffected> {

    /**
     *  受害用户总人数
     */
    int countAffectedByDate(@Param("start") Integer start, @Param("end") Integer end);
}
