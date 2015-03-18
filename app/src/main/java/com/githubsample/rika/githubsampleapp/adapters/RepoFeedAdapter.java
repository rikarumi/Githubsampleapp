package com.githubsample.rika.githubsampleapp.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.githubsample.rika.githubsampleapp.R;
import com.githubsample.rika.githubsampleapp.model.NewsFeed;

import java.util.List;

/**
 * Created by dm03 on 17/03/15.
 */
public class RepoFeedAdapter extends RecyclerView.Adapter<RepoFeedAdapter.RepoFeedHolder> {

    public List<NewsFeed> newsFeedList;

    public RepoFeedAdapter(RecyclerView recyclerView){
        //recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

       // ViewObservable.bindView(recyclerView, GitHub.client().hottestRepositories().map(Response::Object);

    }

    @Override
    public RepoFeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newsfeed, parent, false);

        return new RepoFeedHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoFeedHolder holder, int position) {
        NewsFeed newsFeed = newsFeedList.get(position);
        holder.feed_desc.setText(newsFeed.getFeed_content());
        //holder.img_avatar.setImageBitmap(newsFeed.getUser_avatar());
    }

    @Override
    public int getItemCount() {
        return newsFeedList.size();
    }

    public class RepoFeedHolder extends RecyclerView.ViewHolder {
        private TextView feed_desc;
        private ImageView img_avatar;

        public RepoFeedHolder(View view){
            super(view);
            feed_desc = (TextView) view.findViewById(R.id.feed_description);
            //img_avatar = (ImageView) view.findViewById(R.id.img_avatar);
        }
    }
}
