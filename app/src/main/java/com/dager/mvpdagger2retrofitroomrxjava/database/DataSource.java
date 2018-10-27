package com.dager.mvpdagger2retrofitroomrxjava.database;

import java.util.List;



public interface DataSource<T> {

    void upset(T item);

    void upsetItems(List<T> items);

    int countRssItem();
    void deleteItem(T item);
    void hasData();

}
