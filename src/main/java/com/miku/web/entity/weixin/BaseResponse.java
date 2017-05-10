package com.miku.web.entity.weixin;

import com.alibaba.fastjson.annotation.JSONField;
import com.miku.web.tools.StringUtil;

/**
 * 微信API响应报文对象基类<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class BaseResponse extends BaseModel {
    //错误码
    @JSONField(name="errcode")
    private String errcode;
    //错误信息
    @JSONField(name="errmsg")
    private String errmsg;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        String result = this.errmsg;
        //将接口返回的错误信息转换成中文，方便提示用户出错原因
        if (StringUtil.isNotBlank(this.errcode) && !ResultType.SUCCESS.getCode().toString().equals(this.errcode)) {
            ResultType resultType = ResultType.get(this.errcode);
            if(resultType != null) {
                result = resultType.getDescription();
            }
        }
        return result;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
