package cn.edu.computer.classcheckin.service;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.util.List;

import cn.edu.computer.classcheckin.MainActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



/**
 * Created by panfei on 2018/2/23.
 */

public class OkHttpService<T>  extends AsyncTask<String, Void, T> {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private OkHttpClient client = new OkHttpClient();

    private Class<T> clzz;
    private Handler uiHandler;
    private int msgCode;
    public OkHttpService(Class<T> clzz, Handler handler, int msgCode){
        this.clzz = clzz;
        this.msgCode = msgCode;
        this.uiHandler = handler;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected T doInBackground(String... args) {
        Request request = new Request.Builder().url(args[0]).build();
        try (Response response = client.newCall(request).execute()) {
            String respJsonData = response.body().string();
            return JSON.parseObject(respJsonData,clzz);
        }catch (Exception ex){
            Log.e(LOG_TAG, "doInBackground",ex);
        }
        return null;
    }

    @Override
    protected void onPostExecute(T result){
        if(result == null){
            return;
        }
        Message msg = uiHandler.obtainMessage();
        msg.what = msgCode;
        msg.obj = result;
        uiHandler.sendMessage(msg);
    }
}
