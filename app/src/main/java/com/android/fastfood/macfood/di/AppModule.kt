package com.android.fastfood.macfood.di

import com.android.fastfood.macfood.data.api.ApiService
import com.android.fastfood.macfood.data.datasource.MealsDataSource
import com.android.fastfood.macfood.data.datasource.MealsDataSourceImpl
import com.android.fastfood.macfood.ui.repository.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{
    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit{

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-RapidAPI-Key", "8a3e9cf984msh44517a3458f3fc4p18ca8ejsnf35ec0f2d6e7")
                    .addHeader("X-RapidAPI-Host", "kfc-chickens.p.rapidapi.com")
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://kfc-chickens.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesMealsDataSource(apiService: ApiService) : MealsDataSource{
        return MealsDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesMealsRepository(mealsDataSource: MealsDataSource) : MealsRepository{
        return MealsRepository(mealsDataSource)
    }
}