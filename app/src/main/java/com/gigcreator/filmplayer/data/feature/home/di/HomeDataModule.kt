package com.gigcreator.filmplayer.data.feature.home.di

import android.content.Context
import com.gigcreator.filmplayer.data.feature.home.HomeRepositoryImpl
import com.gigcreator.filmplayer.data.feature.home.datasource.HomeRemoteDataSource
import com.gigcreator.filmplayer.data.feature.home.datasource.impl.HomeRemoteDataSourceImpl
import com.gigcreator.filmplayer.domain.feature.home.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeDataModule {

    @Provides
    @Singleton
    fun provideHomeRemoteDataSource(@ApplicationContext context: Context): HomeRemoteDataSource =
        HomeRemoteDataSourceImpl(context)

    @Provides
    @Singleton
    fun provideHomeRepository(
        remoteDataSource: HomeRemoteDataSource,
    ): HomeRepository = HomeRepositoryImpl(remoteDataSource)

}