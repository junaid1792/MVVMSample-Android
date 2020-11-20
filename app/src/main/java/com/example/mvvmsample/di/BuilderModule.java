package com.example.mvvmsample.di;

import com.example.mvvmsample.ui.home.HomeActivity;
import com.example.mvvmsample.ui.home.HomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by junaid on 20-Oct-20.
 * <p>
 * Binds all sub-components within the app.
 */
/**
 * Binds all sub-components within the app.
 */

@Module
public abstract class BuilderModule {


    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity bindHomeActivity();


}
