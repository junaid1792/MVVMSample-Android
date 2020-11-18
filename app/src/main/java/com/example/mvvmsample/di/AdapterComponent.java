package com.example.mvvmsample.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by junaid on 20-Oct-20.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AdapterComponent {
}
