package com.githubsample.rika.githubsampleapp.adapters;

import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.githubsample.rika.githubsampleapp.R;
import com.githubsample.rika.githubsampleapp.model.NewsFeed;
import com.rejasupotaro.octodroid.models.User;


public class HomeFeedAdapter extends RecyclerView.Adapter<HomeFeedAdapter.ViewHolder>{

    public TextView feed_content;
    private NewsFeed[] newsFeed;

    String usrname, password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    User user;

    public HomeFeedAdapter(NewsFeed[] newsFeed){
        this.newsFeed = newsFeed;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View feedContentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsfeed,null);
        ViewHolder viewHolder = new ViewHolder(feedContentView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.useravatar.setImageBitmap(newsFeed[position].getUser_avatar());
        holder.feedcontent.setText(newsFeed[position].getFeed_content());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView feedcontent;
        public ImageView useravatar;

        public ViewHolder(View feedContentView){
            super(feedContentView);
            feedcontent = (TextView)feedContentView.findViewById(R.id.feed_content);
            useravatar = (ImageView) feedContentView.findViewById(R.id.user_avatar);
        }
    }
}
