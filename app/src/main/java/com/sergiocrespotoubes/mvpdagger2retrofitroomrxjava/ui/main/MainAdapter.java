package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.MyApplication;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.R;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.network.pojo.CityListData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<CityListData> data;
    private Context context;
    Picasso picasso;

    public MainAdapter(Context context, List<CityListData> data) {
        this.data = data;
        this.context = context;
        picasso = MyApplication.appComponent.getPicasso();
    }


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

        holder.tvCity.setText(data.get(position).getName());
        holder.tvDesc.setText(data.get(position).getDescription());

        String images = data.get(position).getBackground();

        picasso.with(context)
                .load(images)
                .into(holder.background);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(CityListData Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity, tvDesc;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.city);
            tvDesc = itemView.findViewById(R.id.hotel);
            background = itemView.findViewById(R.id.image);

        }


        public void click(final CityListData cityListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }
    }


}
