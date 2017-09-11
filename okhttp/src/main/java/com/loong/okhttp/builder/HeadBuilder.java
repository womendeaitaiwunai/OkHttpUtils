package com.loong.okhttp.builder;

import com.loong.okhttp.OkHttpUtils;
import com.loong.okhttp.request.OtherRequest;
import com.loong.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
