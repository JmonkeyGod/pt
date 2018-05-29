package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.MdnTrack;
import com.ai.oidd.pt.vo.Behavor;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 疑似追踪 html
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
public interface MdnTrackMapper extends Mapper<MdnTrack> {

    /**
     * 查询用户所有终端
     *
     * @param mdn
     * @return
     */
    List<String> queryDistinctTerminal(@Param("mdn") String mdn, @Param("start") String start, @Param("end") String end);

    List<Behavor> queryAllBehavorOnConditions(@Param("mdn") String mdn, @Param("terminalType") String terminalType
            , @Param("start") String start, @Param("end") String end);

}
