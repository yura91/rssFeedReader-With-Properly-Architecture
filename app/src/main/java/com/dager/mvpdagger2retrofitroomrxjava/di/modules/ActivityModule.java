package com.dager.mvpdagger2retrofitroomrxjava.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dager.mvpdagger2retrofitroomrxjava.di.scopes.ActivityScoped;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(@NonNull final Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityScoped
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScoped

    Context provideActivityContext() {
        return mActivity;
    }
}