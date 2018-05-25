package com.ai.oidd.pt.service;

import com.ai.oidd.pt.common.msg.TableResultResponse;
import com.ai.oidd.pt.common.util.Query;

import java.util.List;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
public interface BaseService<T> {
    /**
     * 查询
     *
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 通过mdn查询
     *
     * @param id
     * @return
     */
    T selectById(Object id);

    /**
     * 根据ID集合来查询
     *
     * @param ids
     * @return
     */
//    List<T> selectListByIds(List<Object> ids);

    /**
     * 查询列表
     *
     * @param entity
     * @return
     */
    List<T> selectList(T entity);


    /**
     * 获取所有对象
     *
     * @return
     */
    List<T> selectListAll();


    /**
     * 查询总记录数
     *
     * @return
     */
//    Long selectCountAll();

    /**
     * 查询总记录数
     *
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     *  查询符合条件的样本
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    TableResultResponse<T> listByPage(Query query);

    /**
     * 添加
     *
     * @param entity
     */
    void insert(T entity);


    /**
     * 插入 不插入null字段
     *
     * @param entity
     */
    void insertSelective(T entity);

    void update(T entity);

    /**
     * 删除
     *
     * @param entity
     */
//    void delete(T entity);

    /**
     * 根据mdn删除
     *
     * @param mdn
     */
//    void deleteByMdn(Object mdn);


    /**
     * 根据mdn更新
     *
     * @param entity
     */
//    void updateByMdn(T entity);


    /**
     * 不update null
     *
     * @param entity
     */
//    void updateSelectiveByMdn(T entity);

    /**
     * 根据ID集合批量删除
     *
     * @param ids
     */
    void deleteBatchByIds(Object[] ids);


    /**
     * 批量更新
     *
     * @param entitys
     */
//    void updateBatch(List<T> entitys);
}

