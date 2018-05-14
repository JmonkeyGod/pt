package com.ai.oidd.pt.service.impl;

import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.common.util.Query;
import com.ai.oidd.pt.service.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-03-30
 */
public class BaseServiceImpl<M extends Mapper<T>, T> implements BaseService<T> {
    @Autowired
    protected M mapper;

    @Override
    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

//    @Override
//    public List<T> selectListByIds(List<Object> ids) {
//        return mapper.selectByIds(ids);
//    }

    @Override
    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    @Override
    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    public TableResultResponse<T> selectByQuery(Query query) {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

        Example example = new Example(clazz);

        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return new TableResultResponse<T>(result.getTotal(), list);
    }

    @Override
    public Long selectCount(T entity) {
        return Long.valueOf(mapper.selectCount(entity));
    }

    @Override
    public void insert(T entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }

    @Override
    public void delete(T entity) {
        mapper.delete(entity);
    }

    @Override
    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(T entity) {
        mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void updateSelectiveById(T entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }

//    @Override
//    public void deleteBatchByIds(List<Object> ids) {
//        mapper.batchDeleteByIds(ids);
//    }
//
//    @Override
//    public void updateBatch(List<T> entitys) {
//        mapper.batchUpdate(entitys);
//    }
}
