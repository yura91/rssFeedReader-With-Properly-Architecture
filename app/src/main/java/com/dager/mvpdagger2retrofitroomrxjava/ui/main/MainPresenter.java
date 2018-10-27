package com.dager.mvpdagger2retrofitroomrxjava.ui.main;


import com.dager.mvpdagger2retrofitroomrxjava.MyApplication;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;
import com.dager.mvpdagger2retrofitroomrxjava.database.repository.RssRepository;
import com.dager.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Rss;
import com.dager.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


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
                .subscribeWith(new DisposableSingleObserver<Response<Rss>>() {

                    @Override
                    public void onSuccess(Response<Rss> rss) {
                        List<RssItem> rssItemList = new ArrayList<>();
                        for (int i = 0; i < rss.body().getChannel().getItem().size(); i++) {
                            RssItem rssItem = new RssItem();
                            rssItem.setId(i + 1);
                            rssItem.setItem(rss.body().getChannel().getItem().get(i));
                            rssItemList.add(rssItem);
                        }
                        rssRepository.upsetItems(rssItemList);
                        view.getRssListSuccess(rssItemList);
                    }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.getRssListSuccess(rssRepository.getAll());
                    }

                }));
    }

}
