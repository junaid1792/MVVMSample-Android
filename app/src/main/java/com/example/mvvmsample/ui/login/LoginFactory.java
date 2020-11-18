package com.example.mvvmsample.ui.login;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginFactory implements ViewModelProvider.Factory{
        LoginRepo loginRepo;

public LoginFactory(LoginRepo loginRepo){
        this.loginRepo=loginRepo;
        }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(loginRepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}