package com.lcw.study.clonebaemin.data

import com.lcw.study.clonebaemin.BuildConfig
import com.lcw.study.clonebaemin.data.login.LoginData
import com.lcw.study.clonebaemin.data.login.RequestLoginInfoData
import com.lcw.study.clonebaemin.data.search.SearchData
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @POST("api/token/")
    fun getToken(@Body requestLoginInfoData: RequestLoginInfoData): Single<LoginData>


    @GET("api/restaurants/query_search/")
    @Headers("X-Api-Key: ${BuildConfig.api_search_key}")
    fun getSearch(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Single<SearchData>

}