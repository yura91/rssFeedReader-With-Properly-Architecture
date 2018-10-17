package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava;

import android.app.Activity;
import android.app.Application;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.components.AppComponent;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.components.DaggerAppComponent;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.AppModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.DbModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.NetworkModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.squareup.picasso.Picasso;

import net.danlew.android.joda.JodaTimeAndroid;



public class MyApplication extends Application {

    public static AppComponent appComponent;

    private ApiControllerRetrofit apiControllerRetrofit;
    private Picasso picasso;
    public static MyRoomDatabase db;

    public static MyApplication get(Activity activity){
        return (MyApplication)activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();


        JodaTimeAndroid.init(this);



        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dbModule(new DbModule(this))
                .networkModule(new NetworkModule("https://habrahabr.ru/rss/"))
                .build();

        apiControllerRetrofit = appComponent.getApiControllerRetrofit();
        picasso = appComponent.getPicasso();
        db = appComponent.getMyRoomDatabase();

    }

}
