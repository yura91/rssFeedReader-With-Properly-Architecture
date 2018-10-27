package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.dager.mvpdagger2retrofitroomrxjava.MyApplication;
import com.dager.mvpdagger2retrofitroomrxjava.R;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;
import com.dager.mvpdagger2retrofitroomrxjava.database.repository.RssRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    Parcelable mListState;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private final String KEY_ITEMS_LIST = "items_list";
    @Inject
    MainContract.Presenter presenter;

    @BindView(R.id.list)
    RecyclerView list;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Inject
    RssRepository rssRepository;

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
                pullToRefresh.setRefreshing(false);
            }
        });
        ButterKnife.bind(this);
        MainComponent mainComponent = MyApplication.appComponent.activityComponent().build();
        mainComponent.inject(this);
        list.setLayoutManager(new LinearLayoutManager(this));
        presenter.setView(this);
        if (savedInstanceState != null) {
            mListState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE);
            if (mListState != null) {
                getRssListSuccess(rssRepository.getAll());
                list.getLayoutManager().onRestoreInstanceState(mListState);
            }
        } else {
            presenter.loadData();
        }

    }

    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);

        // Save list state
        mListState = list.getLayoutManager().onSaveInstanceState();
        state.putParcelable(KEY_RECYCLER_STATE, mListState);
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

    public void getRssListSuccess(List<RssItem> rssItems) {
        MainAdapter mainAdapter = new MainAdapter(this, (ArrayList<RssItem>) rssItems);
        removeWait();
        list.setAdapter(mainAdapter);
    }
}
