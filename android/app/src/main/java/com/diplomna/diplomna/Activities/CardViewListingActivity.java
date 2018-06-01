package com.diplomna.diplomna.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.diplomna.diplomna.Models.ListingData;
import com.diplomna.diplomna.Models.MyRecyclerViewAdapter;
import com.diplomna.diplomna.R;

import java.util.ArrayList;

public class CardViewListingActivity extends AppCompatActivity {

    private static final byte[] image = new byte[] { (byte)0xe0, 0x4f, (byte)0xd0,
        0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
        0x30, 0x30, (byte)0x9d };
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_listing);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(this, getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<ListingData> getDataSet() {
        ArrayList results = new ArrayList<ListingData>();
        for (int index = 0; index < 20; index++) {
            ListingData obj = new ListingData("Some product name" + index,
                    "dealer name " + index, "some ppUnit" + index,
                    "some units" + index, image);

            results.add(index, obj);
        }
        return results;
    }
}
