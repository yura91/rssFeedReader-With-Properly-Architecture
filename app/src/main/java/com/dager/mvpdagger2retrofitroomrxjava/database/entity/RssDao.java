package com.dager.mvpdagger2retrofitroomrxjava.database.entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface RssDao {

    @Query("SELECT * FROM RssItem")
    List<RssItem> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upset(RssItem rssItem);

    @Query("SELECT * FROM RssItem LIMIT 1")
    RssItem getUser();

    @Query("SELECT COUNT(*) from RssItem")
    int countRssItem();

}