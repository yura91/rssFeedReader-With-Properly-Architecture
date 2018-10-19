package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dager.mvpdagger2retrofitroomrxjava.MyApplication;
import com.dager.mvpdagger2retrofitroomrxjava.R;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MainContract.View {



    @Inject
    MainContract.Presenter presenter;

    @Inject
    Retrofit retrofit;

    @Inject
    Picasso picasso;

    @BindView(R.id.list)
    RecyclerView list;

    @BindView(R.id.progress)
    ProgressBar progressBar;



    List lCityListResponse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeRefreshLayout pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((MainAdapter)list.getAdapter()).clearData();
                presenter.loadData();
                presenter.loadData();
                pullToRefresh.setRefreshing(false);
            }
        });
        ButterKnife.bind(this);
        MainComponent mainComponent = MyApplication.appComponent.activityComponent().build();
        mainComponent.inject(this);
        list.setLayoutManager(new LinearLayoutManager(this));
        presenter.setView(this);

        presenter.loadData();

    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    public void getRssListSuccess(ArrayList<Item> cityListResponse) {
        MainAdapter mainAdapter = new MainAdapter(this, cityListResponse);
        removeWait();
        list.setAdapter(mainAdapter);
    }
}
