package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.MdnMonitor;
import com.ai.oidd.pt.vo.CityCodeQty;
import com.ai.oidd.pt.vo.CommonDateQty;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 * 高危号码监测Mapper
 * @author sunbin-71738
 * @date 2018-04-28
 */
public interface MdnMonitorMapper extends Mapper<MdnMonitor> {

    /**
     * 高危终端占比
     * @param start
     * @param end
     * @return
     */
    float terminalRatioByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  高危终端按天
     * @param start
     * @param end
     * @return
     */
    List<CommonDateQty> countTerminalByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  高危号码占比
     * @param start
     * @param end
     * @return
     */
    float mdnRatioByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  高危号码按天
     * @param start
     * @param end
     * @return
     */
    List<CommonDateQty> countMdnByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     *  高危区域按天
     * @param start
     * @param end
     * @return
     */
    List<CityCodeQty> countAreaByDate(@Param("start") Integer start, @Param("end") Integer end);

}
