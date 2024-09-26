package com.lcw.study.clonebaemin.data.search.remote

import com.lcw.study.clonebaemin.data.search.SearchData
import io.reactivex.Single

interface SearchRemoteDataSource {
    fun getSearch(query: String, page: Int): Single<SearchData>
}