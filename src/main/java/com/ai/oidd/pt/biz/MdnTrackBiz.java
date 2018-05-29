package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.entity.MdnTrack;
import com.ai.oidd.pt.mapper.MdnTrackMapper;
import com.ai.oidd.pt.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        MdnBehavorTrack mdnBehavorTrack = null;
        List<String> terminals;
        if (null != params) {
            String mdn = params.getMdn();
            if (StringUtils.isNotEmpty(mdn)) {
                String startTime = params.getStartTime().toString();
                String endTime = params.getEndTime().toString();

                terminals = mapper.queryDistinctTerminal(mdn, startTime, endTime);


                List<Behavor> behavors;
                List<MdnTerminal> mdnTerminals = new ArrayList<>();
                MdnTerminal mdnTerminal;
                MdnBehavor mdnBehavor;
                for (String s : terminals) {
                    mdnTerminal = new MdnTerminal();
                    mdnTerminal.setTerminal(s);

                    mdnBehavor = new MdnBehavor();
                    behavors = mapper.queryAllBehavorOnConditions(mdn, s, startTime, endTime);
                    mdnBehavor.setBehavors(behavors);

                    mdnTerminal.setMdnBehavor(mdnBehavor);
                    mdnTerminals.add(mdnTerminal);
                }

                mdnBehavorTrack = new MdnBehavorTrack();
                mdnBehavorTrack.setMdn(mdn);
                mdnBehavorTrack.setMdnTerminal(mdnTerminals);
            }
        }

        ObjectRestResponse<MdnBehavorTrack> entityObjectRestResponse = new ObjectRestResponse<>();
        entityObjectRestResponse.data(mdnBehavorTrack);
        return entityObjectRestResponse;
    }
}
