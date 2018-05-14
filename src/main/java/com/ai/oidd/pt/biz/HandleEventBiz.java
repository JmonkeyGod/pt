package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.entity.HandleEvent;
import com.ai.oidd.pt.mapper.HandleEventMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-11
 */
@Service
public class HandleEventBiz extends BaseBiz<HandleEventMapper,HandleEvent> {

    public List<HandleEvent> getHandleEventByTime(@Param("start") Integer start
            , @Param("end") Integer end) {
        Example example = new Example(HandleEvent.class);

        if(0 != start && 0!= end){
            Example.Criteria criteria = example.createCriteria();
            criteria.andBetween("date", start, end);
        }
        return mapper.selectByExample(example);
    }
}
