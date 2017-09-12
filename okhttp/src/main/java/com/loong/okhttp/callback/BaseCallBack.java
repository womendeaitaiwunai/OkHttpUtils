package com.loong.okhttp.callback;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.loong.okhttp.request.RequestCall;

import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by lxl on 2017/9/12.
 */

public abstract class BaseCallBack<T> extends Callback<T> {
    private WeakReference<Context> contextWR;
    private ProgressDialog progressDialog;
    private boolean showDialog=true;
    public BaseCallBack(Context context){
        contextWR=new WeakReference<>(context);
    }

    public BaseCallBack setShowDialog(boolean showDialog){
        this.showDialog=showDialog;
        return this;
    }

    public BaseCallBack setProgressDialog(ProgressDialog progressDialog){
        this.progressDialog=progressDialog;
        return this;
    }


    @Override
    public void onBefore(final RequestCall requestCall, Request request, final int id) {
        if (showDialog){
            if (contextWR!=null&&contextWR.get()!=null){
                if (progressDialog==null){
                    showProgressDialog("正在处理数据");
                    progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            requestCall.cancel();
                            BaseCallBack.this.onError(null,new Exception("net cancel"),id);
                        }
                    });
                }else {
                    showProgressDialog("正在处理数据");
                    progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            requestCall.cancel();
                            BaseCallBack.this.onError(null,new Exception("net cancel"),id);
                        }
                    });
                }
            }
        }
    }


    @Override
    public void onError(Call call, Exception e, int id) {
        Log.i("负累","onError");
        e.printStackTrace();
        if (e instanceof java.net.SocketTimeoutException){
            if (contextWR.get()!=null)Toast.makeText(contextWR.get(), "请求超时.请检查网络..", Toast.LENGTH_SHORT).show();
        }if (e.getMessage().equals("net cancel")){
            if (contextWR.get()!=null)Toast.makeText(contextWR.get(), "请求被取消...", Toast.LENGTH_SHORT).show();
        }
        hideProgressDialog();
    }

    @Override
    public void onResponse(T response, int id) {
        Log.i("负累","onResponse");
        hideProgressDialog();
    }

    public void showProgressDialog(String message){
        showProgressDialog("",message);
    }

    public void showProgressDialog(String title,String message){
        showProgressDialog(title,message,true);
    }

    public void showProgressDialog(String title,String message,boolean isFinish){
        if (progressDialog==null&&contextWR.get()!=null){
            progressDialog=new ProgressDialog(contextWR.get());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage(message);
            progressDialog.setTitle(title);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setCancelable(isFinish);
            progressDialog.show();
        }else if (!progressDialog.isShowing()){
            progressDialog.setMessage(message);
            progressDialog.show();
        }else {
            progressDialog.setMessage(message);
        }
    }

    public void hideProgressDialog(){
        if (contextWR.get()!=null&&progressDialog!=null&&progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
