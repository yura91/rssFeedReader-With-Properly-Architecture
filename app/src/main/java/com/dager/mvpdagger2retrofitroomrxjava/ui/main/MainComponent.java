package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import com.dager.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Subcomponent;

@ActivityScoped
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {

    void inject(final MainActivity activity);

    @Subcomponent.Builder
    interface Builder {
        MainComponent build();
    }

}