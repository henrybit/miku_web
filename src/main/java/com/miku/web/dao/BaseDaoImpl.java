package com.miku.web.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ffw team on 2016/11/27.
 * @version 1.0
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    protected final static String PAGE_START = "start";
    protected final static String PAGE_END = "end";

    @Autowired
    public SqlSessionTemplate sqlSession;
    protected String NAMESPACE = "com.miku.web.dao.BaseDao.";
    protected String GET_ONE = "getOne";
    protected String GET_LIST = "getList";
    protected String UPDATE_ONE = "updateOne";
    protected String DELETE_ONE = "deleteOne";
    protected String DROP_ONE = "dropOne";
    protected String INSERT_ONE = "addOne";
    protected String GET_COUNT = "getCount";


    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    public T getOne(Map map) {
        return this.sqlSession.selectOne(getNameSpace()+GET_ONE, map);
    }

    public List<T> getList(Map map) {
        return this.sqlSession.selectList(getNameSpace()+GET_LIST, map);
    }

    public int updateOne(Map map) {
        return this.sqlSession.update(getNameSpace()+UPDATE_ONE, map);
    }

    public int deleteOne(Map map) {
        return this.sqlSession.update(getNameSpace()+DELETE_ONE, map);
    }

    public int dropOne(Map map) {
        return this.sqlSession.delete(getNameSpace()+DROP_ONE, map);
    }

    public int addOne(T t) {
        return this.sqlSession.insert(getNameSpace()+INSERT_ONE, t);
    }

    public int getCount(Map map) {
        return this.sqlSession.selectOne(getNameSpace()+GET_COUNT,map);
    }

    public String getNameSpace() {
        return NAMESPACE;
    }
}