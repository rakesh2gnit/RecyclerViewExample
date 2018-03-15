package com.bizshare.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakesh.Kumar on 15-03-2018.
 */

public class MainActivity extends AppCompatActivity implements SampleAdpater.OnItemClicked {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<User> userList = new ArrayList<>();
    private SampleAdpater adpater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList.add(new User("Your Name"));

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adpater = new SampleAdpater(userList, this);
        recyclerView.setAdapter(adpater);

    }

    @Override
    public void onLongClick() {
        Log.e(TAG, "On Long Click");
    }

    @Override
    public void onClick() {
        Log.e(TAG, "On Click");
    }
}
