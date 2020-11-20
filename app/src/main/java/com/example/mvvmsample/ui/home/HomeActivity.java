package com.example.mvvmsample.ui.home;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvmsample.R;
import com.example.mvvmsample.databinding.ActivityHome2Binding;
import com.example.mvvmsample.models.CatImage;
import com.example.mvvmsample.networkUtils.ServerResponse;
import com.example.mvvmsample.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import okhttp3.Response;

import static com.example.mvvmsample.networkUtils.ServerResponse.StatusType.ERROR;
import static com.example.mvvmsample.networkUtils.ServerResponse.StatusType.LOADING;

public class HomeActivity extends BaseActivity implements HomeNavigator {
    HomeViewModel homeViewModel;
    @Inject
    HomeFactory homeFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        ActivityHome2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_home2);

        homeViewModel =  new ViewModelProvider(this, homeFactory).get(HomeViewModel.class);
        binding.setViewModel(homeViewModel);
        homeViewModel.setNavigator(this);
        callApi();
    }


    private void processCatApi(ServerResponse<ArrayList<CatImage>> response) {
        switch (response.statusType) {
            case LOADING:
                showProgressDialog(this);
                break;

            case SUCCESS:
                homeViewModel.setdata();
                dismissProgressDialog();
                break;

            case ERROR:
                dismissProgressDialog();
                break;
        }
    }

    @Override
    public void callApi() {
        homeViewModel.callCatApi();
        homeViewModel.getCatImage().observe(this, this::processCatApi);
    }
}