package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.modules;

import android.content.Context;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.qualifier.ApplicationContext;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;


@Module(includes = AppModule.class)
public class PicassoModule {

    @Provides
    @ApplicationScoped
    public Picasso providePicasso(@ApplicationContext Context context){
        return new Picasso.Builder(context)
                .build();
    }

}
