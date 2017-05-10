package com.miku.web.entity.weixin;

import com.miku.web.tools.JSONUtil;

/**
 * 抽象实体基类<br>
 * 实现toJsonString方法
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public abstract class BaseModel {
    @Override
    public String toString() {
        return JSONUtil.toJson(this);
    }
}
