package android.anjahyun.study.repository

import android.anjahyun.study.data.LoginVO
import android.anjahyun.study.data.local.TokenDao
import android.anjahyun.study.network.ApiService
import com.google.gson.JsonObject
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val api: ApiService, private val dao: TokenDao): LoginRepository {
    override fun login(id: String, pw: String): Single<Response<JsonObject>> {
        return api.login(LoginVO(id, pw))
    }
}