package com.dager.mvpdagger2retrofitroomrxjava.database.repository;

import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssDao;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;

import java.util.List;

import javax.inject.Inject;

public class RssDataSource implements RssRepository {

    private RssDao rssDao;

    @Inject
    public RssDataSource(RssDao rssDao) {
        this.rssDao = rssDao;
    }

    @Override
    public void updateItems(List items) {

    }

    @Override
    public void intert(RssItem item) {
        rssDao.insert(item);
    }

    @Override
    public void insertItems(List<RssItem> items) {
        for (RssItem item: items) {
            rssDao.insert(item);
        }
    }

    @Override
    public void updateItem(RssItem item) {
        rssDao.update(item);
    }

    @Override
    public void deleteItem(RssItem item) {

    }

    @Override
    public void hasData() {

    }

    @Override
    public RssItem getRss() {
        return null;
    }

    @Override
    public List<RssItem> getAll() {
        return rssDao.getAll();
    }
}