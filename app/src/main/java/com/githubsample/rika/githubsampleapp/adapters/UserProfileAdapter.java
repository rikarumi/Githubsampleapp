package com.githubsample.rika.githubsampleapp.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.githubsample.rika.githubsampleapp.R;
import com.githubsample.rika.githubsampleapp.model.UserAccount;
import com.rejasupotaro.octodroid.GitHub;
import com.rejasupotaro.octodroid.models.User;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import rx.android.view.ViewObservable;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.UserViewHolder>{
    List<UserAccount> userAccount = new ArrayList<UserAccount>();
    UserAccount account;
    View profileView;
    UserViewHolder viewHolder;

    public UserProfileAdapter(RecyclerView recyclerView){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        ViewObservable.bindView(recyclerView, GitHub.client().user()).cache().subscribe( s ->{
                    List <UserAccount> userAccount = setUser(s.entity());
                    addUser(userAccount);
                }
        );
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        profileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_profile, null);
        viewHolder = new UserViewHolder(profileView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserAccount acc = userAccount.get(position);
        holder.avatar.setImageBitmap(acc.getAvatar());
        holder.user_name.setText(acc.getUsername());
        holder.company.setText(acc.getCompany());
        holder.location.setText(acc.getLocation());
        holder.email.setText(acc.getEmail());
        holder.blog.setText(acc.getBlog());
        holder.join_date.setText(acc.getJoinDate());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public List<UserAccount> setUser(User user){
        Bitmap bitmap;
        account = new UserAccount();
        account.setEmail(user.getEmail());
        account.setUsername(user.getName());
        account.setCompany(user.getCompany());
        account.setLocation(user.getLocation());
        account.setBlog(user.getBlog());
        account.setJoinDate(user.getCreatedAt());
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(user.getAvatarUrl()).getContent());
            account.setAvatar(bitmap);

        }catch (Exception ex){
            Log.d("Image url: ",user.getAvatarUrl());
        }
        userAccount.add(account);
        return userAccount;
    }

    public void addUser(List<UserAccount> userAccount){
        this.userAccount.addAll(userAccount);
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        public ImageView avatar;
        public TextView user_name, email, blog, company, location, join_date;

        public UserViewHolder(View view){
            super(view);

            avatar = (ImageView) view.findViewById(R.id.profile_picture);
            user_name = (TextView)view.findViewById(R.id.user_name);
            company = (TextView)view.findViewById(R.id.company_name);
            location = (TextView)view.findViewById(R.id.location);
            email = (TextView)view.findViewById(R.id.email);
            blog = (TextView)view.findViewById(R.id.blog_url);
            join_date = (TextView)view.findViewById(R.id.join_date);
        }
    }
}
