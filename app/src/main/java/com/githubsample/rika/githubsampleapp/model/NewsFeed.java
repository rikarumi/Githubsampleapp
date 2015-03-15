package com.githubsample.rika.githubsampleapp.model;

import android.graphics.Bitmap;

/**
 * Created by dm03 on 13/03/15.
 */
public class NewsFeed {

    private Bitmap user_avatar;
    private String feed_content;

    public NewsFeed (Bitmap user_avatar, String feed_content){
        this.user_avatar = user_avatar;
        this.feed_content = feed_content;
    }

    public Bitmap getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(Bitmap user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getFeed_content() {
        return feed_content;
    }

    public void setFeed_content(String feed_content) {
        this.feed_content = feed_content;
    }
}
