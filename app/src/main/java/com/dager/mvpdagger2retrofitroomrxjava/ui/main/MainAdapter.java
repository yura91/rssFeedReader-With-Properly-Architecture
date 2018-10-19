package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dager.mvpdagger2retrofitroomrxjava.MyApplication;
import com.dager.mvpdagger2retrofitroomrxjava.R;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Item;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Rss;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Scanner;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<Item> data;
    private Context context;
    Picasso picasso;

    public MainAdapter(Context context, ArrayList<Item> data) {
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
        Document documentT = Jsoup.parse(data.get(position).getTitle());
        String srcT = documentT.select("img").attr("src");
        documentT.select("img").remove();
        String title = documentT.toString();
        holder.tvCity.setText(Html.fromHtml(title));

        Document documentD = Jsoup.parse(data.get(position).getDescription());
        String srcD = documentD.select("img").attr("src");
        documentD.select("img").remove();
        String desc = documentD.toString();
        holder.tvDesc.setText(Html.fromHtml(desc));
        if(srcD != "" && srcD != null)
        Picasso.with(context).load(srcD).into(holder.image);
        else {
           holder.image.setImageDrawable(null);
        }

    }

    @Override
    public int getItemCount() {
       return data.size();
    }


   /* @Override
    public int getItemCount() {
        //return data.size();
        return Integer.parseInt(null);
    }*/


    public interface OnItemClickListener {
        void onClick(Rss Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity, tvDesc;
        ImageView background, image;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = itemView.findViewById(R.id.city);
            tvDesc = itemView.findViewById(R.id.hotel);
            image = itemView.findViewById(R.id.imageImg);
            background = itemView.findViewById(R.id.image);

        }


        public void click(final Rss Rss, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(Rss);
                }
            });
        }
    }


}
