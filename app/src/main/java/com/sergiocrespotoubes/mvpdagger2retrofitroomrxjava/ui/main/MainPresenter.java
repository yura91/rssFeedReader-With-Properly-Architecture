package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;


import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository.UserRepository;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.ApiControllerRetrofit;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Item;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.Rss;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.root.BaseContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;

    private CompositeDisposable compositeDisposable;
    ApiControllerRetrofit apiControllerRetrofit;
    UserRepository userRepository;

    public MainPresenter(MainContract.Model model) {
        this.model = model;
        apiControllerRetrofit = MyApplication.appComponent.getApiControllerRetrofit();
        userRepository = MyApplication.appComponent.getUserRepository();
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

                        List<User> userList = new ArrayList<>();
                        for (Item item : rss.getChannel().getItem()) {
                            User user = new User();
                            user.setItem(item);
                            userList.add(user);
                        }

                        userRepository.insertItems(userList);
                        view.getCityListSuccess(rss.getChannel().getItem());
                    }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        List<Item> userList = new ArrayList<>();
                        for (User user : userRepository.getAll()) {
                            Item item = user.getItem() ;
                            userList.add(item);
                        }
                        view.getCityListSuccess((ArrayList<Item>) userList);
                    }

                }));
    }

}
