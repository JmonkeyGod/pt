package com.ai.oidd.pt.rest;

import com.ai.oidd.pt.common.msg.ObjectRestResponse;
import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.common.util.Query;
import com.ai.oidd.pt.service.BaseService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Slf4j
public class BaseController<Base extends BaseService, Entity> {
    @Autowired
    protected Base base;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity) {
        base.insertSelective(entity);
        return new ObjectRestResponse<>();
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Entity> all(){
        return base.selectListAll();
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<Entity> listByPage(@ApiParam("当前页码") @RequestParam("page") Integer page
            ,@ApiParam("每页条数") @RequestParam("limit") Integer limit){
        Query query = new Query();
        query.setLimit(limit);
        query.setPage(page);
        return base.listByPage(query);
    }

}

