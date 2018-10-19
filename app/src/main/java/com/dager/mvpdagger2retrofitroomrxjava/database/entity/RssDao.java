package com.dager.mvpdagger2retrofitroomrxjava.database.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface RssDao {

    @Query("SELECT * FROM RssItem")
    List<RssItem> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RssItem rssItem);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(RssItem rssItem);

    @Query("SELECT * FROM RssItem LIMIT 1")
    RssItem getUser();

}