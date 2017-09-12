package com.loong.okhttp.callback;

import android.content.Context;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class StringCallback extends BaseCallBack<String>
{
    public StringCallback(Context context) {
        super(context);
    }

    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException
    {
        return response.body().string();
    }
}
