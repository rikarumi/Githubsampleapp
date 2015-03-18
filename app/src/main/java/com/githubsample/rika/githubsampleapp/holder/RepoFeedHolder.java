package com.githubsample.rika.githubsampleapp.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.githubsample.rika.githubsampleapp.R;

/**
 * Created by dm03 on 17/03/15.
 */
public class RepoFeedHolder extends RecyclerView.ViewHolder {
    private TextView feed_desc;
    //private ImageView img_avatar;

    public RepoFeedHolder(View view){
        super(view);
        feed_desc = (TextView) view.findViewById(R.id.feed_description);
       // img_avatar = (ImageView) view.findViewById(R.id.img_avatar);
    }
}