package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserTerminal;
import com.ai.oidd.pt.mapper.UserTerminalMapper;
import com.ai.oidd.pt.vo.CommonDateQty;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
     * 用户终端 - 取最近的一条记录
     */
    public UserTerminal queryUserTerminal(String mdn) {
        Example example = new Example(UserTerminal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mdn", mdn);
        example.setOrderByClause("`date` DESC");

        List<UserTerminal> list = mapper.selectByExample(example);
        if (null != list && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 终端历史
     *
     * @param start
     * @param end
     * @return
     */
    public List<CommonDateQty> countTerQtyByDate(String mdn, Integer start, Integer end) {
        return mapper.countTerQtyByDate(mdn, start, end);
    }
}
