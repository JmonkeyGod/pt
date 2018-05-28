package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.UserAffectedReplay;
import com.ai.oidd.pt.vo.CommonQty;
import com.ai.oidd.pt.vo.MdnQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 诈骗回放 mapper
 *
 * @author sunbin-71738
 * @date 2018-05-28
 */
public interface UserAffectedReplayMapper extends Mapper<UserAffectedReplay> {

    /**
     * 通话时长top5
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return top5
     */
    List<MdnQty> countDurationByDate(@Param("start") Integer start, @Param("end") Integer end);


    /**
     * 诈骗回放
     *
     * @param start 开始时间
     * @param end   结束时间
     * @return top5
     */
    List<CommonQty> countMdnTypeByDate(@Param("mdn") String mdn, @Param("start") Integer start, @Param("end") Integer end);

}
