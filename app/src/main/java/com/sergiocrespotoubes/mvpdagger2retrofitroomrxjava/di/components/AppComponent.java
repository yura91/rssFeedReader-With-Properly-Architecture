package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.components;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.UserDao;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository.UserRepository;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.AppModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.DbModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.NetworkModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules.PicassoModule;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main.MainComponent;
import com.squareup.picasso.Picasso;

import dagger.Component;


@ApplicationScoped
@Component(modules = {
        AppModule.class,
        DbModule.class,
        PicassoModule.class,
        NetworkModule.class})
public interface AppComponent {




    Picasso getPicasso();

    MyRoomDatabase getMyRoomDatabase();

    ApiControllerRetrofit getApiControllerRetrofit();


    MainComponent.Builder activityComponent();


    UserDao getUserDao();
    UserRepository getUserRepository();

}