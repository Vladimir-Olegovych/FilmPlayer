package com.gigcreator.filmplayer.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    /*
    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources {
        return context.resources
    }
     */
}