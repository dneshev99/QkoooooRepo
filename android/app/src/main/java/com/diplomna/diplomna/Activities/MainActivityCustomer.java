package com.diplomna.diplomna.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.diplomna.diplomna.DTOs.CategoryDTO;
import com.diplomna.diplomna.DTOs.SubCategoryDTO;
import com.diplomna.diplomna.R;
import com.diplomna.diplomna.adapters.CategoryAdapter;
import com.diplomna.diplomna.adapters.SubCategoryAdapter;
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

public class MainActivityCustomer extends AppCompatActivity {

    @BindView(R.id.categories_list_view)
    ListView categoryListView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_customer);

        ((DIApplication) this.getApplicationContext()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        categoryListView.setVisibility(View.INVISIBLE);

        API service = retrofit.create(API.class);
        service.getAllCategories().enqueue(new Callback<List<CategoryDTO>>() {
            @Override
            public void onResponse(Call<List<CategoryDTO>> call, Response<List<CategoryDTO>> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    List<CategoryDTO> data = response.body();

                    final CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(),data);
                    categoryListView.setVisibility(View.VISIBLE);
                    categoryListView.setAdapter(adapter);

                    categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent startActivity = new Intent( MainActivityCustomer.this,SubCategoriesActivity.class);
                            startActivity.putExtra("name",adapter.getData().get(i).getName());

                            startActivity(startActivity);
                        }
                    });

                } else {
                    Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_SHORT).show();
                    Log.v(this.getClass().getSimpleName(),"response:" + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<CategoryDTO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.v(this.getClass().getSimpleName(), "error:" + t.getMessage());
            }
        });

    }



}
