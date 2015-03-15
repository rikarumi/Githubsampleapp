package com.githubsample.rika.githubsampleapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.githubsample.rika.githubsampleapp.R;
import com.githubsample.rika.githubsampleapp.model.UserAccount;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ViewHolder>{
    private UserAccount userAccount;
    View profileView;
    ViewHolder viewHolder;

    public UserProfileAdapter(UserAccount userAccount){
        this.userAccount = userAccount;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        profileView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_profile, null);
        viewHolder = new ViewHolder(profileView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.profilepicture.setImageBitmap(userAccount.getAvatar());
        holder.user_name.setText(userAccount.getUsername());
        holder.company.setText(userAccount.getCompany());
        holder.location.setText(userAccount.getLocation());
        holder.email.setText(userAccount.getEmail());
        holder.blog.setText(userAccount.getBlog());
        holder.join_date.setText(userAccount.getJoinDate());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView profilepicture;
        public TextView user_name, email, blog, company, location, join_date;

        public ViewHolder(View feedContentView){
            super(feedContentView);

            profilepicture = (ImageView) feedContentView.findViewById(R.id.profile_picture);
            user_name = (TextView)feedContentView.findViewById(R.id.user_name);
            company = (TextView)feedContentView.findViewById(R.id.company_name);
            location = (TextView)feedContentView.findViewById(R.id.location);
            email = (TextView)feedContentView.findViewById(R.id.email);
            blog = (TextView)feedContentView.findViewById(R.id.blog_url);
            join_date = (TextView)feedContentView.findViewById(R.id.join_date);
        }
    }
}
