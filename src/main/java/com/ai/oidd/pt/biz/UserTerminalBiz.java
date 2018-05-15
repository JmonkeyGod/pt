package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserTerminal;
import com.ai.oidd.pt.mapper.UserTerminalMapper;
import com.ai.oidd.pt.vo.MdnTerQty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-15
 */
@Service
public class UserTerminalBiz extends BaseBiz<UserTerminalMapper, UserTerminal> {

    /**
     *  终端历史
     * @param start
     * @param end
     * @return
     */
    public List<MdnTerQty> countTerQtyByDate(@Param("mdn") String mdn,@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countTerQtyByDate(mdn,start, end);
    }
}
