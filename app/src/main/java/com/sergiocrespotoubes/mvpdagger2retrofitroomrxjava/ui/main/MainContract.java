package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Item;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.ArrayList;
import java.util.Observable;


public interface MainContract {

    interface View extends BaseContract.View {
        void showWait();

        void removeWait();

        void onFailure(String appErrorMessage);

        void getCityListSuccess(ArrayList<Item> cityListResponse);
    }

    interface Presenter extends BaseContract.Presenter {
        void loadData();
    }

    interface Model extends BaseContract.Model {
        Observable result();
    }

}