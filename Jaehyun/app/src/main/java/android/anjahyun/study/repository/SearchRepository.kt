package android.anjahyun.study.repository

import android.anjahyun.study.data.LoginVO
import android.anjahyun.study.data.remote.SearchItem
import android.anjahyun.study.network.ApiService
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class SearchRepository @Inject constructor(private val service: ApiService) {

    fun search(query: String): Single<Response<SearchItem>> {
        return service.search(query, 1)
    }

}