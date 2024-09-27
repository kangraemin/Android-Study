package android.anjahyun.study.network

import android.anjahyun.study.data.LoginVO
import android.anjahyun.study.data.remote.SearchItem
import com.google.gson.JsonObject
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("api/token/")
    fun login(@Body body: LoginVO): Single<Response<JsonObject>>

    @POST("api/token/refresh/")
    fun refresh(@Body body: String): Single<Response<JsonObject>>

    @GET("api/restaurants/query_search/")
    fun search(@Query("query")query: String, @Query("page")page: Int): Single<Response<SearchItem>>

}