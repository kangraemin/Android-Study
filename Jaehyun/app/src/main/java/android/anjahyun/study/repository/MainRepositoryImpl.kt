package android.anjahyun.study.repository

import android.anjahyun.study.data.local.TokenDao
import android.anjahyun.study.network.ApiService
import com.google.gson.JsonObject
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val api: ApiService, private val dao: TokenDao): MainRepository {
    override fun checkAccessToken(): Single<String?> {
        return dao.getToken()
            .map { it.accessToken }
            .subscribeOn(Schedulers.io())
    }

    override fun checkRefreshToken(refreshToken: String?): Single<String> {
        return dao.getToken()
            .map { it.refreshToken }
            .subscribeOn(Schedulers.io())
    }

    override fun refreshAccessToken(refreshToken: String): Single<Response<JsonObject>> {
        return api.refresh(refreshToken)
    }

}