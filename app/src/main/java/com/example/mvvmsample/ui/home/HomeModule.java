package com.example.mvvmsample.ui.home;

import com.example.mvvmsample.ui.login.LoginFactory;
import com.example.mvvmsample.ui.login.LoginRepo;

import dagger.Module;
import dagger.Provides;


@Module
public class HomeModule {

    @Provides
    HomeRepo provideHomeRepository() {
        return new HomeRepo();
    }

    @Provides
    HomeFactory provideHomeFactory(HomeRepo homeRepo) {
        return new HomeFactory(homeRepo);
    }
}
