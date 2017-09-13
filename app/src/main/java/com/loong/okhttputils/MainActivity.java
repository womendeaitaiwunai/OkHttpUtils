package com.loong.okhttputils;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.loong.okhttp.OkHttpUtils;
import com.loong.okhttp.callback.BaseCallBack;
import com.loong.okhttp.callback.BitmapCallback;
import com.loong.okhttp.callback.GsonCallback;
import com.loong.okhttp.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.getBitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImageView bitmap= (ImageView) findViewById(R.id.bitmap);
//                OkHttpUtils.get().url("http://192.168.0.211:8080/bodycheck/sysuser/photostudio_getHmacRandom.action")
//                        .build().execute(new StringCallback(MainActivity.this) {
//                    @Override
//                    public void onResponse(String response, int id) {
//                        super.onResponse(response, id);
//                        Log.i("自雷","onResponse");
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        super.onError(call, e, id);
//                        Log.i("自雷","onError");
//                        //startActivity(new Intent(MainActivity.this,Activity1.class));
//                       // finish();
//                    }
//                });


                OkHttpUtils.post()
                        .url("http://www.mrtdephoto.net/sysuser/photostudio_getProvinceCity.action")
                        .build().execute(new GsonCallback<ProvinceCityDto>(MainActivity.this) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        super.onError(call, e, id);
                    }

                    @Override
                    public void onResponse(ProvinceCityDto response, int id) {
                        super.onResponse(response, id);
                        //Log.i("得到数据",response.toString());
                        //Log.i("得到数据",response.getProvinces().size()+"");
                    }
                });
            }
        });
    }
}
