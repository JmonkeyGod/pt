package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.UserCircle;
import com.ai.oidd.pt.vo.CityCodeQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 用户活动范围Mapper
 * @author sunbin-71738
 * @date 2018-05-14
 */
public interface UserCircleMapper extends Mapper<UserCircle> {

    List<CityCodeQty> countMdnCircleByCityCode(@Param("mdn") String mdn, @Param("start") Integer start, @Param("end") Integer end);
}
