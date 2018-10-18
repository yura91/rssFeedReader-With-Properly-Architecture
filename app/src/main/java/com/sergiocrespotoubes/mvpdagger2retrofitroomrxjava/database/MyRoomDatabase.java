package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.UserDao;



@Database(entities = {User.class}, version = MyRoomDatabase.VERSION)
@TypeConverters({Converters.class})
public abstract class MyRoomDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract UserDao userDao();

}