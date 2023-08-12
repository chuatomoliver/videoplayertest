package com.example.videoplayer.data


import com.example.videoplayer.domain.abstraction.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *  Dependency binding of data module
 */
@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @get:[Binds Singleton]
    val RepositoryImpl.repository: Repository
}