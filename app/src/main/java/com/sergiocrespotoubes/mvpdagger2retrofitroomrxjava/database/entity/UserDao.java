package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;



@Dao
public interface UserDao {




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);

    @Query("SELECT * FROM user LIMIT 1")
    User getUser();

}