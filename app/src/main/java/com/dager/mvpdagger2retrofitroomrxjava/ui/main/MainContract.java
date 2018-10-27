package com.dager.mvpdagger2retrofitroomrxjava.ui.main;


import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;
import com.dager.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.List;


public interface MainContract {

    interface View extends BaseContract.View {
        void showWait();

        void removeWait();

        void onFailure(String appErrorMessage);

        void getRssListSuccess(List<RssItem> rssItems);
    }

    interface Presenter extends BaseContract.Presenter {
        void loadData();
    }

}