package com.githubsample.rika.githubsampleapp.model;

import android.graphics.Bitmap;

/**
 * Created by dm03 on 12/03/15.
 */
public class UserAccount {
    private Bitmap avatar;
    private String username;
    private String email;
    private String blog;
    private String company;
    private String location;
    private String joinDate;

    /*
    public UserAccount (Bitmap avatar, String username, String company, String location, String email, String blog, String joinDate){
        this.avatar = avatar;
        this.username = username;
        this.email = email;
        this.blog = blog;
        this.company = company;
        this.location = location;
        this.joinDate = joinDate;
    }
    */
    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
