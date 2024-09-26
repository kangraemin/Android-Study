package com.lcw.study.clonebaemin.data.login.remote

import com.lcw.study.clonebaemin.data.login.LoginData
import io.reactivex.Single

interface LoginDataSource {
    fun requestLogin(username: String, password: String): Single<LoginData>
}