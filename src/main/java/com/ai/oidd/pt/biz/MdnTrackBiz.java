package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.entity.MdnTrack;
import com.ai.oidd.pt.mapper.MdnTrackMapper;
import com.ai.oidd.pt.vo.MdnBehavor;
import com.ai.oidd.pt.vo.MdnBehavorTrack;
import com.ai.oidd.pt.vo.MdnPosition;
import com.ai.oidd.pt.vo.MdnTrackParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-05-29
 */
@Service
public class MdnTrackBiz extends BaseBiz<MdnTrackMapper, MdnTrack> {


    public ObjectRestResponse<MdnBehavorTrack> queryMdnTrackByConditions(MdnTrackParams params) {

        Example example = new Example(MdnTrack.class);
        Example.Criteria criteria = example.createCriteria();
        boolean isCriteria = false;

        String mdn = null;
        if(null != params){
            mdn = params.getMdn();

            if (StringUtils.isNotEmpty(mdn)) {
                isCriteria = true;
                criteria.andEqualTo("mdn", mdn);
            }

            Date start = params.getStartTime();
            Date end = params.getEndTime();
            if (null != start && null != end) {
                isCriteria = true;
                criteria.andBetween("time", start, end);
            }
        }

        List<MdnTrack> list;
        if (isCriteria) {
            list = mapper.selectByExample(example);
        } else {
            list = mapper.selectByExample(new Example(MdnTrack.class));
        }

        MdnBehavorTrack mdnBehavorTrack = null;
        if(list.size()>0){

            MdnPosition mdnPosition;
            MdnBehavor mdnBehavor;
             List<MdnPosition> positions = new ArrayList<>();
             List<MdnBehavor> behavors= new ArrayList<>();
            for(MdnTrack track : list){
                mdnPosition = new MdnPosition();
                mdnPosition.setArea(track.getArea());
                mdnPosition.setPosition(track.getPosition());
                mdnPosition.setTime(track.getTime());
                positions.add(mdnPosition);

                mdnBehavor = new MdnBehavor();
                mdnBehavor.setOppoMdn(track.getOppoMdn());
                mdnBehavor.setTime(track.getTime());
                mdnBehavor.setType(track.getType());
                behavors.add(mdnBehavor);
            }

             mdnBehavorTrack = new MdnBehavorTrack();
            mdnBehavorTrack.setMdn(mdn);
            mdnBehavorTrack.setBehavors(behavors);
            mdnBehavorTrack.setPositions(positions);
        }


        ObjectRestResponse<MdnBehavorTrack> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(mdnBehavorTrack);
        return entityObjectRestResponse;
    }
}
