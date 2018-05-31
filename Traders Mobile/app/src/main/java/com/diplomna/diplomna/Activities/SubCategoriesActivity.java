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

import com.diplomna.diplomna.DTOs.SubCategoryDTO;
import com.diplomna.diplomna.R;
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

public class SubCategoriesActivity extends AppCompatActivity {

    @BindView(R.id.subCatView)
    ListView categoryListView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);

        ((DIApplication) this.getApplicationContext()).getApplicationComponent().inject(this);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        categoryListView.setVisibility(View.INVISIBLE);

        API service = retrofit.create(API.class);

        service.getAllSubCategoriesByCategory((String) intent.getExtras().get("name")).enqueue(new Callback<List<SubCategoryDTO>>() {
            @Override
            public void onResponse(Call<List<SubCategoryDTO>> call, Response<List<SubCategoryDTO>> response) {

                if (response.isSuccessful()) {
                    categoryListView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    final SubCategoryAdapter adapterSubCategories = new SubCategoryAdapter(getApplicationContext(), response.body());

                    categoryListView.setAdapter(adapterSubCategories);


                    categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(getApplicationContext(), adapterSubCategories.getData().get(i).getName(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<List<SubCategoryDTO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.v(this.getClass().getSimpleName(), "error:" + t.getMessage());
            }
        });
    }
}
