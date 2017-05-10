package com.miku.web.entity.weixin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 {
 "access_token":"ACCESS_TOKEN",
 "expires_in":7200,
 "refresh_token":"REFRESH_TOKEN",
 "openid":"OPENID",
 "scope":"SCOPE"
 }
 * Created by henrybit on 2017/4/18.
 */
public class GetTokenResponse extends BaseResponse{
    @JSONField(name="access_token")
    protected String accessToken;
    @JSONField(name="expires_in")
    protected long expiresTime;
    @JSONField(name="refresh_token")
    protected String refreshToken;
    @JSONField(name="openid")
    protected String openid;
    @JSONField(name="scope")
    protected String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
