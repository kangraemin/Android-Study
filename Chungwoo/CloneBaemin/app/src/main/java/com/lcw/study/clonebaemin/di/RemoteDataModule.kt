package com.lcw.study.clonebaemin.di


import com.lcw.study.clonebaemin.data.login.remote.LoginDataSource
import com.lcw.study.clonebaemin.data.login.remote.LoginRemoteDataSourceImpl
import com.lcw.study.clonebaemin.data.login.repository.LoginRepository
import com.lcw.study.clonebaemin.data.login.repository.LoginRepositoryImpl
import com.lcw.study.clonebaemin.data.search.SearchListRepository
import com.lcw.study.clonebaemin.data.search.SearchListRepositoryImpl
import com.lcw.study.clonebaemin.data.search.remote.SearchRemoteDataSource
import com.lcw.study.clonebaemin.data.search.remote.SearchRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteDataModule {
    @Binds
    abstract fun bindLoginDataSource(loginImpl: LoginRemoteDataSourceImpl): LoginDataSource
    @Binds
    abstract fun bindLoginRepository(impl: LoginRepositoryImpl):LoginRepository
    @Binds
    abstract fun bindSearchListDataSource(impl: SearchRemoteDataSourceImpl): SearchRemoteDataSource
    @Binds
    abstract fun bindSearchListRepository(impl: SearchListRepositoryImpl): SearchListRepository

}