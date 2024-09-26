package com.lcw.study.clonebaemin.data.search.remote

import com.lcw.study.clonebaemin.data.ApiService
import com.lcw.study.clonebaemin.data.search.SearchData
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService) : SearchRemoteDataSource {


    override fun getSearch(query: String, page: Int): Single<SearchData> {
        return apiService
            .getSearch(query = query, page = page)
            .subscribeOn(Schedulers.io())
    }
}