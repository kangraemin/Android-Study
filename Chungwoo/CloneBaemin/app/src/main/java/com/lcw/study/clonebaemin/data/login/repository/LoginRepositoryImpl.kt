package com.lcw.study.clonebaemin.data.login.repository

import com.lcw.study.clonebaemin.data.login.LoginData
import com.lcw.study.clonebaemin.data.login.remote.LoginDataSource
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource): LoginRepository {
    override fun requestLogin(username: String, password: String): Single<LoginData> {
       return loginDataSource.requestLogin(username = username,password = password)
    }

}