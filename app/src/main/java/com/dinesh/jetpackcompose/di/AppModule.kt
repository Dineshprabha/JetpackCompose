package com.dinesh.jetpackcompose.di

import com.dinesh.jetpackcompose.media_player.Constants.BASE_URL
import com.dinesh.jetpackcompose.media_player.data.api.MediaAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providesMediaAPI(retrofit: Retrofit) : MediaAPIService{
        return retrofit.create(MediaAPIService::class.java)
    }
}