package com.example.mvvmsample.networkUtils;

import android.util.Log;


import com.example.mvvmsample.App;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by junaid on 08-Aug-19.
 */

public class NetworkInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response;
        if (!new ServiceManager(App.getInstance()).isNetworkAvailable()) {
            throw (new IOException("no internet"));

        } else {
            try {
                response = chain.proceed(chain.request());
            }
            catch (IOException e){
                throw (new IOException("something went wrong"));

            }



        }
        return response;
    }
}




