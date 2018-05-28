package com.ai.oidd.pt.mapper;

import com.ai.oidd.pt.entity.*;
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
public interface MdnAbnMonitorMapper extends Mapper<MdnAbnBehavor> {

    /**
     * 异常行为省份占比
     * @param start
     * @param end
     * @return
     */
    List<MdnAbnCityCount> provinceRatioByDate(@Param("start") Integer start, @Param("end") Integer end);

    /**
     * 异常行为本省排行
     * @param start
     * @param end
     * @return
     */
    List<MdnAbnCityCount> provinceTopByDate(@Param("start") Integer start, @Param("end") Integer end, @Param("procode") String procode);

    /**
     * 异常行为省份占比
     * @param start
     * @param end
     * @return
     */
    List<MdnAbnTypeCount> typeRatioByDate(@Param("start") Integer start, @Param("end") Integer end, @Param("procode") String procode);


    /**
     * 异常行为本省按天统计
     * @param start
     * @param end
     * @return
     */
    List<MdnAbnTypeCountByDay> typeStaByDate(@Param("start") Integer start, @Param("end") Integer end, @Param("procode") String procode);


    /**
     * 异常行为按mdn排top
     * @param start
     * @param end
     * @return
     */
    List<MdnAbnTypeTop> typeTopByDate(@Param("start") Integer start, @Param("end") Integer end, @Param("procode") String procode,  @Param("type") String type);





}
