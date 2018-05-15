package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.UserCommQty;
import com.ai.oidd.pt.vo.MdnQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 用户通讯量Mapper
 * @author sunbin-71738
 * @date 2018-05-14
 */
public interface UserCommQtyMapper extends Mapper<UserCommQty> {

    List<MdnQty> countMdnQtyByDate(@Param("mdn") String mdn,@Param("start") Integer start, @Param("end") Integer end);
}
