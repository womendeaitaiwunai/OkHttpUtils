package com.loong.okhttp.callback;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class BitmapCallback extends BaseCallBack<Bitmap>
{
    public BitmapCallback(Context context) {
        super(context);
    }

    @Override
    public Bitmap parseNetworkResponse(Response response , int id) throws Exception
    {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }

}
