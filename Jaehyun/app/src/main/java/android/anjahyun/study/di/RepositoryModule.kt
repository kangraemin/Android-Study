package android.anjahyun.study.di

import android.anjahyun.study.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsMainRepository(repositoryImpl: MainRepositoryImpl): MainRepository
    @Binds
    abstract fun bindsLoginRepository(repositoryImpl: LoginRepositoryImpl): LoginRepository
    @Binds
    abstract fun bindSharedRepository(repositoryImpl: SharedRepositoryImpl): SharedRepository
}