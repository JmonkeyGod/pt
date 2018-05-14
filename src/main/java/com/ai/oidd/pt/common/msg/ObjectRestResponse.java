package com.ai.oidd.pt.common.msg;

import com.ai.oidd.pt.common.Constants;
import lombok.Data;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
@Data
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    String code = Constants.STATUS_OK;

    public ObjectRestResponse code(String  code) {
        this.code = code;
        return this;
    }

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }



}