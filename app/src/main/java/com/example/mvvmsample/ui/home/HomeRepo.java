package com.example.mvvmsample.ui.home;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmsample.models.CatImage;
import com.example.mvvmsample.networkUtils.Api;
import com.example.mvvmsample.networkUtils.ApiClient;
import com.example.mvvmsample.networkUtils.ServerResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepo {

    private Api api;
    public HomeRepo() {
        api = ApiClient.getClient().create(Api.class);
    }


    public MutableLiveData<ServerResponse<ArrayList<CatImage>>> getCatImge(String source){
        MutableLiveData<ServerResponse<ArrayList<CatImage>>> catImageMutableLiveData = new MutableLiveData<>();
        catImageMutableLiveData.setValue(ServerResponse.loading(null));
        api.getCatImage(source).enqueue(new  Callback<ArrayList<CatImage>>() {
            @Override
            public void onResponse(Call<ArrayList<CatImage>> call,
                                   Response<ArrayList<CatImage>> response) {
                if (response.isSuccessful()){
                    catImageMutableLiveData.setValue(ServerResponse.success(response.body(),""));
                }else{
                    switch (response.code()){
                        case 400:
                            catImageMutableLiveData.setValue(ServerResponse.error("",response.body()));
                            break;
                        case 404:
                            catImageMutableLiveData.setValue(ServerResponse.error("",response.body()));
                            break;
                        case 403:
                            catImageMutableLiveData.setValue(ServerResponse.error("",response.body()));
                            break;
                        case 500:
                            catImageMutableLiveData.setValue(ServerResponse.error("",response.body()));
                            break;
                        default:
                            catImageMutableLiveData.setValue(ServerResponse.error("",response.body()));
                            break;

                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CatImage>> call, Throwable t) {
                catImageMutableLiveData.setValue(ServerResponse.error(t.toString(), null));
            }
        });
        return catImageMutableLiveData;
    }

}
