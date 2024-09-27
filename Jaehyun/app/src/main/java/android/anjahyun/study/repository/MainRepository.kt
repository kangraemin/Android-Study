package android.anjahyun.study.repository

import com.google.gson.JsonObject
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response


interface MainRepository {
    fun checkAccessToken(): Single<String?>
    fun checkRefreshToken(refreshToken: String?): Single<String>
    fun refreshAccessToken(refreshToken: String): Single<Response<JsonObject>>
}