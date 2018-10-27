package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import com.dager.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {

    @Provides
    @ActivityScoped
    public MainContract.Presenter provideMainPresenter() {
        return new MainPresenter();
    }

}
