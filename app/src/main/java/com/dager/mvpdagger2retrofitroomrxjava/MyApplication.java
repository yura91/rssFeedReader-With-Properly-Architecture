package com.dager.mvpdagger2retrofitroomrxjava;

import android.app.Application;

import com.dager.mvpdagger2retrofitroomrxjava.di.components.AppComponent;
import com.dager.mvpdagger2retrofitroomrxjava.di.components.DaggerAppComponent;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.AppModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.DbModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.NetworkModule;



public class MyApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dbModule(new DbModule(this))
                .networkModule(new NetworkModule("https://habrahabr.ru/rss/"))
                .build();
    }

}
