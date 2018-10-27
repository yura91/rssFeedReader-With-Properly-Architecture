package com.dager.mvpdagger2retrofitroomrxjava;

import android.app.Activity;
import android.app.Application;

import com.dager.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.dager.mvpdagger2retrofitroomrxjava.di.components.AppComponent;
import com.dager.mvpdagger2retrofitroomrxjava.di.components.DaggerAppComponent;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.AppModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.DbModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.NetworkModule;
import com.dager.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;



public class MyApplication extends Application {

    public static AppComponent appComponent;

    private ApiControllerRetrofit apiControllerRetrofit;
    public static MyRoomDatabase db;

    public static MyApplication get(Activity activity){
        return (MyApplication)activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();



        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dbModule(new DbModule(this))
                .networkModule(new NetworkModule("https://habrahabr.ru/rss/"))
                .build();

        apiControllerRetrofit = appComponent.getApiControllerRetrofit();
        db = appComponent.getMyRoomDatabase();

    }

}
