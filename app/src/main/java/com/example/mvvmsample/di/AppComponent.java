package com.example.mvvmsample.di;



import com.example.mvvmsample.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by junaid on 20-Oct-20.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class,BuilderModule.class})
public interface AppComponent extends AndroidInjector<App> {
    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }
}