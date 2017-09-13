package com.loong.okhttp.callback;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

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
        try {
            Gson gson=new Gson();
            Class<T> tClass= (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return gson.fromJson(response.body().string(),tClass);
        }catch (Exception e){
            onError(null,new Exception("gson error"),id);
            return null;
        }

    }

    @Override
    public void onError(Call call, Exception e, int id) {
        super.onError(call, e, id);
    }

    @Override
    public void onResponse(T response, int id) {
        super.onResponse(response, id);
    }
}
