package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.UserTerminal;
import com.ai.oidd.pt.vo.MdnTerQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 用户终端Mapper
 * @author sunbin-71738
 * @date 2018-05-14
 */
public interface UserTerminalMapper extends Mapper<UserTerminal> {

    List<MdnTerQty> countTerQtyByDate(@Param("mdn") String mdn,@Param("start") Integer start, @Param("end") Integer end);
}
