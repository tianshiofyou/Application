package com.teng.model.dao.jdbc;

import java.util.List;

/**
 * Created by admin on 2018/1/11.
 */
public interface BaseDao<T>{

        T getOne(String condition) throws Exception;

        List<T> getAll() throws Exception;

        void update(T t) throws Exception;

        void delete(String condition) throws Exception;

        void addOne(T t) throws Exception;

        void addList(List<T> ts) throws Exception;
}
