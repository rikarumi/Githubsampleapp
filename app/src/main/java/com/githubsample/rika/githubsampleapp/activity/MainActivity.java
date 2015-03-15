package com.githubsample.rika.githubsampleapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.githubsample.rika.githubsampleapp.R;
import com.githubsample.rika.githubsampleapp.adapters.UserProfileAdapter;
import com.githubsample.rika.githubsampleapp.model.UserAccount;
import com.rejasupotaro.octodroid.GitHub;
import com.rejasupotaro.octodroid.models.User;

import java.io.InputStream;
import java.net.URL;

import rx.android.view.ViewObservable;

public class MainActivity extends Activity {
    public static final String myPref_username = "username";
    public static final String myPref_password = "password";
    RecyclerView RECYCLER;
    UserAccount userAccount = new UserAccount();
    UserProfileAdapter profileAdapter;
    SharedPreferences sharedPreferences;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataProfileUser();
    }

    public void getDataProfileUser(){

        RECYCLER = (RecyclerView)findViewById(R.id.recycler);
        RECYCLER.setLayoutManager(new LinearLayoutManager(this));
        sharedPreferences = getSharedPreferences(LoginActivity.myPreferences, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(myPref_username) && sharedPreferences.contains(myPref_password)){
            GitHub.client().authorization(sharedPreferences.getString(myPref_username,""),sharedPreferences.getString(myPref_password,""));
            ViewObservable.bindView(RECYCLER,GitHub.client().user()).subscribe(s -> {
                if (s.isSuccessful()){
                    setDataProfileUser(s.entity());
                }
                return;
            });
        }

    }

    public void setDataProfileUser(User user){

        userAccount.setUsername(user.getName());
        userAccount.setBlog(user.getBlog());
        userAccount.setCompany(user.getCompany());
        userAccount.setLocation(user.getLocation());
        userAccount.setEmail(user.getEmail());
        userAccount.setJoinDate(user.getCreatedAt().toString());

        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(user.getAvatarUrl()).getContent());
            userAccount.setAvatar(bitmap);
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Fail loading image", Toast.LENGTH_SHORT);
        }

        profileAdapter = new UserProfileAdapter(userAccount);
        RECYCLER.setAdapter(profileAdapter);

    }
}
