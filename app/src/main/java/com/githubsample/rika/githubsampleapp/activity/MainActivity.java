package com.githubsample.rika.githubsampleapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.githubsample.rika.githubsampleapp.R;
import com.githubsample.rika.githubsampleapp.adapters.UserProfileAdapter;

public class MainActivity extends Activity {
    public static final String myPref_username = "username";
    public static final String myPref_password = "password";
    RecyclerView RECYCLER;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RECYCLER = (RecyclerView) findViewById(R.id.recycler);
        RECYCLER.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RECYCLER.setLayoutManager(linearLayoutManager);
        adapter = new UserProfileAdapter(RECYCLER);
        RECYCLER.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
