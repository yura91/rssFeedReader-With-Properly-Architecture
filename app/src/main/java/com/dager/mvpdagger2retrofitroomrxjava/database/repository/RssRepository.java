package com.dager.mvpdagger2retrofitroomrxjava.database.repository;

import com.dager.mvpdagger2retrofitroomrxjava.database.DataSource;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;

import java.util.List;


public interface RssRepository extends DataSource<RssItem> {

    RssItem getRss();

    List<RssItem> getAll();
}
