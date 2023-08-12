package com.example.videoplayer.core.executor


import com.example.videoplayer.BuildConfig
import com.example.videoplayer.data.RemoteDataSource
import com.example.videoplayer.data.remote.ApiServiceFactory
import com.example.videoplayer.data.remote.VideoPlayerService
import com.example.videoplayer.data.remote.source.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RemoteDataModule {

    @get:[Binds Singleton]
    val RemoteDataSourceImpl.remoteDataSource: RemoteDataSource

    companion object {
        @get:[Provides Singleton]
        val provideMoshi: Moshi
            get() = Moshi.Builder()
                //if you have more adapters, add them before this line:
                //this needs to be last since this will be the last resort
                .add(KotlinJsonAdapterFactory()).build()

        @[Provides Singleton]
        fun provideApiService(): VideoPlayerService =
            ApiServiceFactory.makeAPiService(BuildConfig.DEBUG, provideMoshi)
    }
}