package com.bizshare.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Rakesh.Kumar on 15-03-2018.
 */

public class SampleAdpater extends RecyclerView.Adapter<SampleAdpater.MyViewHolder> {
//https://github.com/rakesh2gnit/RecyclerViewExample.git
    private static final String TAG = SampleAdpater.class.getSimpleName();
    private List<User> userList;
    private OnItemClicked onItemClicked;

    public SampleAdpater(List<User> userList, OnItemClicked onItemClicked) {
        this.userList = userList;
        this.onItemClicked = onItemClicked;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.txtView.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public TextView txtView;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtView = (TextView) itemView.findViewById(R.id.txtview);
            txtView.setOnClickListener(this);
            txtView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.txtview) {
                Log.e(TAG, "On Click");
                if(onItemClicked!=null){
                    onItemClicked.onClick();
                }
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (v.getId() == R.id.txtview) {
                Log.e(TAG, "On Long Click");
                if(onItemClicked!=null){
                    onItemClicked.onLongClick();
                }
                return true;
            }
            return false;
        }
    }

    protected interface OnItemClicked{
        void onLongClick();
        void onClick();
    }
}
