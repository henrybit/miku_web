package com.miku.web.dao;

import com.miku.web.entity.JoinGame;
import com.miku.web.tools.StringTools;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by henrybit on 2017/3/30.
 */
@Repository
public class JoinGameDaoImpl extends BaseDaoImpl<JoinGame> implements JoinGameDao{
    protected String NAMESPACE = "com.miku.web.dao.JoinGameDao.";

    @Override
    public String getNameSpace() {
        if (StringTools.isEmpty(NAMESPACE))
            return super.NAMESPACE;
        return NAMESPACE;
    }

    public Integer getRefereeTimes(String wechatId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("refereeWechatId", wechatId);
        return this.getSqlSession().selectOne(getNameSpace()+"getCount", map);
    }
}
