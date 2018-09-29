package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    @Provides
    @ActivityScoped
    public MainContract.Presenter provideMainPresenter(MainContract.Model model){
        return new MainPresenter(model);
    }

    @Provides
    @ActivityScoped
    public MainContract.Model provideMainModel(){
        return new MainModel();
    }

}
