package com.dager.mvpdagger2retrofitroomrxjava.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dager.mvpdagger2retrofitroomrxjava.R;
import com.dager.mvpdagger2retrofitroomrxjava.database.entity.RssItem;
import com.dager.mvpdagger2retrofitroomrxjava.network.pojo.Rss;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<RssItem> data;
    private Context context;

    public MainAdapter(Context context, ArrayList<RssItem> data) {
        this.data = data;
        this.context = context;
    }

    void clearData(){
        data.clear();
        notifyDataSetChanged();
    }

    public ArrayList<RssItem> getData() {
        return data;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        Document documentT = Jsoup.parse(data.get(position).getItem().getTitle());
        String srcT = documentT.select("img").attr("src");
        documentT.select("img").remove();
        String title = documentT.toString();
        holder.tvTitle.setText(Html.fromHtml(title));

        Document documentD = Jsoup.parse(data.get(position).getItem().getDescription());
        String srcD = documentD.select("img").attr("src");
        documentD.select("img").remove();
        String desc = documentD.toString();
        holder.tvDesc.setText(Html.fromHtml(desc));
        if (srcD != "" && srcD != null) {
            Picasso.with(context).load(srcD).into(holder.image);
        }
        else {
           holder.image.setImageDrawable(null);
        }

    }

    @Override
    public int getItemCount() {
       return data.size();
    }


    public interface OnItemClickListener {
        void onClick(Rss Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDesc;
        ImageView background, image;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            image = itemView.findViewById(R.id.imageImg);
            background = itemView.findViewById(R.id.imageBackground);

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
