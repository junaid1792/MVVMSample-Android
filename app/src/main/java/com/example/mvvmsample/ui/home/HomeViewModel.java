package com.example.mvvmsample.ui.home;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmsample.models.CatImage;
import com.example.mvvmsample.networkUtils.ServerResponse;
import com.example.mvvmsample.ui.login.LoginRepo;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private HomeRepo homeRepo;
    private MutableLiveData<ServerResponse<ArrayList<CatImage>>> catImageMutableLiveData;
    HomeNavigator homeNavigator;
    public HomeViewModel(HomeRepo homeRepo) {
        this.homeRepo = homeRepo;
    //    this.imageUrl.set(catImageMutableLiveData.getValue().getData().getUrl());
    }

    public void onServerRefreshClick() {
        homeNavigator.callApi();

    }
    public final ObservableField<String> imageUrl = new ObservableField<>();

    public void callCatApi() {
        catImageMutableLiveData = homeRepo.getCatImge("application/json");

    }

    public LiveData<ServerResponse<ArrayList<CatImage>>> getCatImage() {
        return catImageMutableLiveData;
    }

    public void setdata() {
        this.imageUrl.set(catImageMutableLiveData.getValue().getData().get(0).getUrl());

    }

    public void setNavigator(HomeNavigator homeNavigator) {
        this.homeNavigator=homeNavigator;
    }
}
