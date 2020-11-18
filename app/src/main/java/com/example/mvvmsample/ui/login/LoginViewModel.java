package com.example.mvvmsample.ui.login;

import android.text.TextUtils;

import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.utils.CommonUtils;

public class LoginViewModel extends ViewModel {

    private LoginRepo loginRepo;

    public LoginViewModel(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        if (!CommonUtils.isEmailValid(email)) {
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
    }


    public void onServerLoginClick() {

    }
}
