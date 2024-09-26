package com.lcw.study.clonebaemin.data.login.repository

import com.lcw.study.clonebaemin.data.login.LoginData
import io.reactivex.Completable
import io.reactivex.Single

interface LoginRepository {
    fun requestLogin(username: String, password: String): Single<LoginData>
}