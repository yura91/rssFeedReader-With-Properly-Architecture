package com.dager.mvpdagger2retrofitroomrxjava.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssDao;



@Database(entities = {RssItem.class}, version = MyRoomDatabase.VERSION)
@TypeConverters({Converters.class})
public abstract class MyRoomDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract RssDao userDao();

}