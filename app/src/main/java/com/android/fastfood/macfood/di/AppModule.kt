package com.android.fastfood.macfood.di

import com.android.fastfood.macfood.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{
    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://kfc-chickens.p.rapidapi.com/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val request = chain.request().newBuilder()
                        .addHeader("X-RapidAPI-Key", "8a3e9cf984msh44517a3458f3fc4p18ca8ejsnf35ec0f2d6e7")
                        .addHeader("X-RapidAPI-Host", "kfc-chickens.p.rapidapi.com")
                        .build()
                    chain.proceed(request)
                }
                .build())
            .build()

    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }
}