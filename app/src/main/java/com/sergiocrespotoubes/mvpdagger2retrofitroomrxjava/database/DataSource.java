package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database;

import android.arch.persistence.room.Query;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;

import java.util.List;



public interface DataSource<T> {

    void intert(T item);
    void insertItems(List<T> items);
    void updateItem(T item);
    void updateItems(List<T> items);
    void deleteItem(T item);
    void hasData();

}
