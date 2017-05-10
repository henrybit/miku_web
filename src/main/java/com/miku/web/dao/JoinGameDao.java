package com.miku.web.dao;

import com.miku.web.entity.JoinGame;

/**
 * Created by henrybit on 2017/3/30.
 */
public interface JoinGameDao extends BaseDao<JoinGame>{

    /**
     * 查询一个用户推荐的人数
     * @param wechatId
     * @return int
     */
    Integer getRefereeTimes(String wechatId);

}
