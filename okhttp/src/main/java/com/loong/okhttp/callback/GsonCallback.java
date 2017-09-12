package com.loong.okhttp.callback;

import android.content.Context;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by lxl on 2017/9/12.
 */

public abstract class GsonCallback<T> extends BaseCallBack<T> {
    public GsonCallback(Context context) {
        super(context);
    }
    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        Gson gson=new Gson();
        Class<T> tClass= (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return gson.fromJson(response.body().string(),tClass);
    }

}
