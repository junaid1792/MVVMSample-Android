package com.example.mvvmsample.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmsample.ui.login.LoginRepo;
import com.example.mvvmsample.ui.login.LoginViewModel;

public class HomeFactory implements ViewModelProvider.Factory{
    HomeRepo homeRepo;

    public HomeFactory(HomeRepo homeRepo){
        this.homeRepo=homeRepo;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) new HomeViewModel(homeRepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}