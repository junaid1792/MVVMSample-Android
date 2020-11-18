package com.example.mvvmsample.di;

import android.content.Context;


import com.example.mvvmsample.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by junaid on 20-Oct-20.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideApplicationContent(App app) {
        return app.getApplicationContext();
    }

   /* @Provides
    @Singleton
    ApiErrorHandler provideApiErrorHandler() {
        return new ApiErrorHandler();
    }


    @Provides
    @Singleton
    LoginSessionManager providePreferenceManager(Context context) {
        return new LoginSessionManager(context);
    }*/
}
