package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Rss;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;



public interface ApiControllerRetrofit {

    @GET("hubs/all")
    Single<Rss> getCityListResponses();

    @GET("/CityListResponses")
    Observable<Rss> getCityListResponsesObservable();





}