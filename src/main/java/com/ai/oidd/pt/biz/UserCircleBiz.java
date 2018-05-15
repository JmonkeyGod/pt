package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserCircle;
import com.ai.oidd.pt.mapper.UserCircleMapper;
import com.ai.oidd.pt.vo.CityCodeQty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 活跃范围
 * @author sunbin-71738
 * @date 2018-05-15
 */
@Service
public class UserCircleBiz extends BaseBiz<UserCircleMapper,UserCircle> {

    /**
     *  终端历史
     * @param start
     * @param end
     * @return
     */
    public List<CityCodeQty> countMdnCircleByCityCode(String mdn, Integer start, Integer end) {
        return mapper.countMdnCircleByCityCode(mdn,start, end);
    }
}
