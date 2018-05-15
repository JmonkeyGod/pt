package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserCircle;
import com.ai.oidd.pt.mapper.UserCircleMapper;
import com.ai.oidd.pt.vo.MdnCityQty;
import org.apache.ibatis.annotations.Param;
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
    public List<MdnCityQty> countMdnCircleByCityCode(@Param("mdn") String mdn,@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countMdnCircleByCityCode(mdn,start, end);
    }
}
