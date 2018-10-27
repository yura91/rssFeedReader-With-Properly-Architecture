package com.dager.mvpdagger2retrofitroomrxjava.di.components;

import com.dager.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssDao;
import com.dager.mvpdagger2retrofitroomrxjava.database.repository.RssRepository;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.AppModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.DbModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.modules.NetworkModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;
import com.dager.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.dager.mvpdagger2retrofitroomrxjava.ui.main.MainComponent;

import dagger.Component;


@ApplicationScoped
@Component(modules = {
        AppModule.class,
        DbModule.class,
        NetworkModule.class})
public interface AppComponent {

    MyRoomDatabase getMyRoomDatabase();

    ApiControllerRetrofit getApiControllerRetrofit();


    MainComponent.Builder activityComponent();


    RssDao getUserDao();
    RssRepository getUserRepository();

}