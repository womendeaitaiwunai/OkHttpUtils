package com.loong.okhttputils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.loong.okhttp.OkHttpUtils;
import com.loong.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lxl on 2017/9/12.
 */

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.getBitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImageView bitmap= (ImageView) findViewById(R.id.bitmap);
                OkHttpUtils.get().url("http://192.168.0.211:8080/bodycheck/sysuser/photostudio_getHmacRandom.action")
                        .build().execute(new StringCallback(Activity2.this) {
                    @Override
                    public void onResponse(String response, int id) {
                        super.onResponse(response, id);
                        Log.i("自雷","onResponse");
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        super.onError(call, e, id);
                        Log.i("自雷","onError");
                        startActivity(new Intent(Activity2.this,Activity3.class));
                        finish();
                    }
                });
            }
        });
    }
}
