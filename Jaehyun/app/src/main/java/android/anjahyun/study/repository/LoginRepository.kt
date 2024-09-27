package android.anjahyun.study.repository

import android.anjahyun.study.data.LoginVO
import android.anjahyun.study.data.local.TokenDao
import android.anjahyun.study.network.ApiService
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

interface LoginRepository {
    fun login(id: String, pw: String): Single<Response<JsonObject>>
}