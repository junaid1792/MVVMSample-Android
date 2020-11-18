package com.example.mvvmsample.ui.login;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.mvvmsample.R;
import com.example.mvvmsample.databinding.ActivityLoginBinding;
import com.example.mvvmsample.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}