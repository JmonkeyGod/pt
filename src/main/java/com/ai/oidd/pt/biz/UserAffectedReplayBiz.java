package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.UserAffectedReplay;
import com.ai.oidd.pt.mapper.UserAffectedReplayMapper;
import com.ai.oidd.pt.vo.MdnQty;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
     * @return top5
     */
    public List<UserAffectedReplay> countMdnTypeByDate(@Param("mdn") String mdn) {
        Example example = new Example(UserAffectedReplay.class);
        Example.Criteria criteria = example.createCriteria();

        boolean isCriteria = false;
        if (StringUtils.isNotEmpty(mdn)) {
            isCriteria = true;
            criteria.andEqualTo("mdn", mdn);
        }

        List<UserAffectedReplay> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
        } else {
            list = mapper.selectByExample(new Example(UserAffectedReplay.class));
        }

        return list;
    }

}
