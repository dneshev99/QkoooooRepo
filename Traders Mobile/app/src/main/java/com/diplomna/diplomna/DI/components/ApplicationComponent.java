package com.diplomna.diplomna.DI.components;


import android.content.Context;
import android.content.SharedPreferences;

import com.diplomna.diplomna.Activities.LoginActivity;
import com.diplomna.diplomna.Activities.MainActivityCustomer;
import com.diplomna.diplomna.Activities.SubCategoriesActivity;
import com.diplomna.diplomna.DI.modules.ApplicationModule;
import com.diplomna.diplomna.DI.modules.RetrofitModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class,AndroidInjectionModule.class, RetrofitModule.class})

public interface ApplicationComponent {

    void inject(LoginActivity app);
    void inject(MainActivityCustomer app);
    void inject(SubCategoriesActivity app);
    Retrofit provideRetrofitClient();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
    Context contextInject();

}
