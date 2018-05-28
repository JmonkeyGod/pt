package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserAffectedReplay;
import com.ai.oidd.pt.mapper.UserAffectedReplayMapper;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.MdnQty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 诈骗回放
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
@Service
public class UserAffectedReplayBiz extends BaseBiz<UserAffectedReplayMapper, UserAffectedReplay> {

    /**
     * 通话时长top5
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return top5
     */
    public List<MdnQty> countDurationByDate(@Param("start") Integer start, @Param("end") Integer end) {
        return mapper.countDurationByDate(start, end);
    }


    /**
     * 诈骗回放
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return top5
     */
    public List<CommonQty> countMdnTypeByDate(@Param("mdn") String mdn, @Param("start") Integer start
            , @Param("end") Integer end) {
        return mapper.countMdnTypeByDate(mdn, start, end);
    }

}
