package com.olzyinnovation.payoneerdemo.api.ApiClient;

import com.olzyinnovation.payoneerdemo.api.paymentOptions.Networks;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("listresult.json/")
    Call<Networks> getNetworks();
}
