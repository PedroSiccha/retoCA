package com.example.retotecnico.di

import com.example.retotecnico.data.network.NoticiaApiClient
import com.example.retotecnico.util.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(Constantes.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideNoticiaApiClient(retrofit: Retrofit): NoticiaApiClient{
        return retrofit.create(NoticiaApiClient::class.java)
    }
}