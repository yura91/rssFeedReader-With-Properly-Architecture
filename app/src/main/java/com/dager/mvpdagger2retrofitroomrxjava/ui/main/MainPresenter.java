package com.dager.mvpdagger2retrofitroomrxjava.ui.main;


import com.dager.mvpdagger2retrofitroomrxjava.MyApplication;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;
import com.dager.mvpdagger2retrofitroomrxjava.database.repository.RssRepository;
import com.dager.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Item;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Rss;
import com.dager.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;

    private CompositeDisposable compositeDisposable;
    ApiControllerRetrofit apiControllerRetrofit;
    RssRepository rssRepository;

    public MainPresenter(MainContract.Model model) {
        this.model = model;
        apiControllerRetrofit = MyApplication.appComponent.getApiControllerRetrofit();
        rssRepository = MyApplication.appComponent.getUserRepository();
        compositeDisposable = new CompositeDisposable();


    }

    @Override
    public void setView(BaseContract.View view) {
        this.view = (MainContract.View) view;
    }

    @Override
    public void dropView() {
        compositeDisposable.clear();
    }

    @Override
    public void
    loadData() {
        getCityListResponses();
    }

    private void getCityListResponses() {
        view.showWait();
        compositeDisposable.add(apiControllerRetrofit.getCityListResponses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Rss>() {

                    @Override
                    public void onSuccess(Rss rss) {

                        List<RssItem> rssItemList = new ArrayList<>();
                        for (Item item : rss.getChannel().getItem()) {
                            RssItem rssItem = new RssItem();
                            rssItem.setItem(item);
                            rssItemList.add(rssItem);
                        }

                        rssRepository.insertItems(rssItemList);
                        view.getRssListSuccess(rss.getChannel().getItem());
                    }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        List<Item> rssList = new ArrayList<>();
                        for (RssItem rssItem : rssRepository.getAll()) {
                            Item item = rssItem.getItem() ;
                            rssList.add(item);
                        }
                        view.getRssListSuccess((ArrayList<Item>) rssList);
                    }

                }));
    }

}
