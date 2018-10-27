package com.dager.mvpdagger2retrofitroomrxjava.network;

import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Rss;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;



public interface ApiControllerRetrofit {

    @GET("hubs/all")
    Single<Response<Rss>> getCityListResponses();

    @GET("/CityListResponses")
    Observable<Rss> getCityListResponsesObservable();





}