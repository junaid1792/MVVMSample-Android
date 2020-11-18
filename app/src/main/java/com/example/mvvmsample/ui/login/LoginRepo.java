package com.example.mvvmsample.ui.login;

import android.text.TextUtils;

import com.example.mvvmsample.utils.CommonUtils;

public class LoginRepo {

    public LoginRepo() {

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

}
