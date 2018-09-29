package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;




public class MainViewHolder extends RecyclerView.ViewHolder {

    public TextView tv_name;
    public TextView tv_date;

    public MainViewHolder(View view) {
        super(view);


        tv_date = view.findViewById(R.id.tv_description);

    }

}
