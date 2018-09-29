package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.CityListResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;



public interface ApiControllerRetrofit {

    @GET("v1/city")
    Single<CityListResponse> getCityListResponses();

    @GET("/CityListResponses")
    Observable<CityListResponse> getCityListResponsesObservable();





}