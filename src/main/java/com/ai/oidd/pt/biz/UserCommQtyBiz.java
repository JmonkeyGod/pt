package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserCommQty;
import com.ai.oidd.pt.mapper.UserCommQtyMapper;
import com.ai.oidd.pt.vo.MdnQty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 通信趋势
 *
 * @author sunbin-71738
 * @date 2018-05-15
 */
@Service
public class UserCommQtyBiz extends BaseBiz<UserCommQtyMapper, UserCommQty> {

    /**
     * 通信趋势
     *
     * @param start
     * @param end
     * @return
     */
    public List<MdnQty> countMdnQtyByDate(String mdn,Integer start, Integer end) {
        return mapper.countMdnQtyByDate(mdn,start, end);
    }
}
