package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.diplomna.diplomna.DTOs.ItemDTO;
import com.diplomna.diplomna.R;
import com.diplomna.diplomna.adapters.ItemAdapter;
import com.diplomna.diplomna.application.DIApplication;
import com.diplomna.diplomna.http.API;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ItemListingActivity extends AppCompatActivity {

    @BindView(R.id.item_list)
    ListView itemsList;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    Retrofit retrofit;

    String subCategoryName, unit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_listing);

        ((DIApplication) this.getApplicationContext()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        subCategoryName = intent.getExtras().getString("name");
        unit = intent.getExtras().getString("unit");

        itemsList.setVisibility(View.INVISIBLE);

        API service = retrofit.create(API.class);

        service.getItemsBySubCategory(subCategoryName).enqueue(new Callback<List<ItemDTO>>() {
            @Override
            public void onResponse(Call<List<ItemDTO>> call, Response<List<ItemDTO>> response) {
                if (response.isSuccessful()) {

                    itemsList.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    final ItemAdapter adapter = new ItemAdapter(getApplicationContext(),response.body(),unit);

                    itemsList.setAdapter(adapter);

                    itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent startActivity = new Intent( ItemListingActivity.this,ItemInfoActivity.class);
                            startActivity.putExtra("item",adapter.getData().get(i));
                            startActivity.putExtra("unit", unit);

                            startActivity(startActivity);
                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(), "Error occurred" , Toast.LENGTH_SHORT).show();
                    Log.d("Error",response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ItemDTO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error occurred",Toast.LENGTH_SHORT).show();
                Log.v(this.getClass().getSimpleName(), "error:" + t.getMessage());
            }
        });
    }
}
