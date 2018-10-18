package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Item;


@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    long id;
    @Embedded
    private Item item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}