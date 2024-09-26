package com.lcw.study.clonebaemin.data.login.remote

import com.lcw.study.clonebaemin.data.ApiService
import com.lcw.study.clonebaemin.data.login.LoginData
import com.lcw.study.clonebaemin.data.login.RequestLoginInfoData
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService) : LoginDataSource {

    override fun requestLogin(username: String, password: String): Single<LoginData> {
        return apiService
            .getToken(RequestLoginInfoData(username = username, password = password))
            .subscribeOn(Schedulers.io())
    }
}