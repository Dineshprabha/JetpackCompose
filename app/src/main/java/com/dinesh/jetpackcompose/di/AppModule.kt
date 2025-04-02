package com.dinesh.jetpackcompose.di

import android.content.Context
import com.dinesh.jetpackcompose.RestApiFakerStore.data.network.APIInterface
import com.dinesh.jetpackcompose.RestApiFakerStore.hasNetwork
import com.dinesh.jetpackcompose.media_player.Constants.BASE_URL
import com.dinesh.jetpackcompose.media_player.Constants.BASE_URL_PRODUCTS
import com.dinesh.jetpackcompose.media_player.data.api.MediaAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache {
        val cacheSize = (10 * 1024 * 1024).toLong() // 10 MB cache size
        return Cache(context.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, @ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(context)) {
                    request.newBuilder().header("Cache-Control", "public, max-age=60").build()
                } else {
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=604800").build()
                }
                chain.proceed(request)
            }
            .build()
    }
    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_PRODUCTS)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) : APIInterface{
        return retrofit.create(APIInterface::class.java)
    }
}