package com.miku.web.dao;

import java.util.List;
import java.util.Map;

/**
 * Dao基类
 * Created by henrybit on 2017/3/30.
 * @version 1.0
 */
public interface BaseDao<T> {
    T getOne(Map map);

    List<T> getList(Map map);

    int updateOne(Map map);

    int deleteOne(Map map);

    int dropOne(Map map);

    int addOne(T t);

    int getCount(Map map);
}
