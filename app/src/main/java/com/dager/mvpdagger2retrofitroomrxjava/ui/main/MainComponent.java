package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import com.dager.mvpdagger2retrofitroomrxjava.di.modules.ActivityModule;
import com.dager.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = {MainModule.class, ActivityModule.class})
public interface MainComponent {

    void inject(final MainActivity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder mainModule(MainModule module);
        Builder activityModule(ActivityModule module);
        MainComponent build();
    }

    MainContract.Presenter getMainPresenter();

}