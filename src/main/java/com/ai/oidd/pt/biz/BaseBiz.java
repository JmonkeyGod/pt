package com.ai.oidd.pt.biz;

import com.ai.oidd.pt.common.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-03-28
 */
public abstract class BaseBiz<M extends Mapper<T>, T> {
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }

    public void insert(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insert(entity);
    }

    public void insertSelective(T entity) {
        EntityUtils.setCreatAndUpdatInfo(entity);
        mapper.insertSelective(entity);
    }

    public void delete(T entity) {
        mapper.delete(entity);
    }

    public void updateById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }

    public void updateSelectiveById(T entity) {
        EntityUtils.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }



}

