package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.CityListResponse;
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

    @Override
    public void getCityListSuccess(CityListResponse cityListResponse) {
        MainAdapter mainAdapter = new MainAdapter(this, cityListResponse.getData());
        removeWait();
        list.setAdapter(mainAdapter);
    }
}
