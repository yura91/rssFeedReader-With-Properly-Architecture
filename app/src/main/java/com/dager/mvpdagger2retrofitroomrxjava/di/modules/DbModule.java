package com.dager.mvpdagger2retrofitroomrxjava.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.dager.mvpdagger2retrofitroomrxjava.database.MyRoomDatabase;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssDao;
import com.dager.mvpdagger2retrofitroomrxjava.database.repository.RssDataSource;
import com.dager.mvpdagger2retrofitroomrxjava.database.repository.RssRepository;
import com.dager.mvpdagger2retrofitroomrxjava.di.scopes.ApplicationScoped;

import dagger.Module;
import dagger.Provides;


@Module
public class DbModule {

    private MyRoomDatabase myRoomDatabase;

    public DbModule(Application mApplication) {
        myRoomDatabase = Room.databaseBuilder(mApplication, MyRoomDatabase.class, "pregnancydb").allowMainThreadQueries().build();
    }

    @Provides
    @ApplicationScoped
    MyRoomDatabase provideMyRoomDatabase() {
        return myRoomDatabase;
    }

    @Provides
    @ApplicationScoped
    RssDao provideRssDao(MyRoomDatabase myRoomDatabase) {
        return myRoomDatabase.rssDao();
    }

    @Provides
    @ApplicationScoped
    RssRepository provideNameRepository(RssDao rssDao) {
        return new RssDataSource(rssDao);
    }

}