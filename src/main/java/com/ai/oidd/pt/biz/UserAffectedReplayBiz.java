package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.entity.UserAffectedReplay;
import com.ai.oidd.pt.mapper.UserAffectedReplayMapper;
import com.ai.oidd.pt.vo.MdnQty;
import com.ai.oidd.pt.vo.UserAffectedReplayVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    /**public List<UserAffectedReplay> countMdnTypeByDate(@Param("mdn") String mdn) {
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
    }*/

    /**
     * 诈骗回放
     *
     * @return top5
     */
    public TableResultResponse<UserAffectedReplayVo> countMdnTypeByDate(@Param("start") int start, @Param("end") int end, @Param("mdn") String mdn) {

        List<UserAffectedReplay> list = mapper.typeReplayByDate(start, end , mdn);
        List<UserAffectedReplayVo> results = new ArrayList<>();
        for(UserAffectedReplay temp : list){
            int date = temp.getTime();
            Boolean flag = false;
            for(UserAffectedReplayVo rs : results){
                if(rs.getTime()==date){
                    flag = true;
                    if(temp.getType().equals("1")){
                        rs.setCallIn(temp.getTotal());
                    }else if(temp.getType().equals("2")){
                        rs.setCallOut(temp.getTotal()*(-1));
                    }else if(temp.getType().equals("3")){
                        rs.setSmsSend(temp.getTotal());
                    }else if(temp.getType().equals("4")){
                        rs.setSmsRec(temp.getTotal()*(-1));
                    }
                    break;
                }
            }
            if(!flag){
                UserAffectedReplayVo newrs = new UserAffectedReplayVo();
                newrs.setTime(temp.getTime());
                if(temp.getType().equals("1")){
                    newrs.setCallIn(temp.getTotal());
                }else if(temp.getType().equals("2")){
                    newrs.setCallOut(temp.getTotal()*(-1));
                }else if(temp.getType().equals("3")){
                    newrs.setSmsSend(temp.getTotal());
                }else if(temp.getType().equals("4")){
                    newrs.setSmsRec(temp.getTotal()*(-1));
                }

                results.add(newrs);
            }
        }
        return new TableResultResponse<>(results.size(), results);

    }

}
