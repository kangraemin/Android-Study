package com.lcw.study.clonebaemin.data.search

import com.lcw.study.clonebaemin.data.search.remote.SearchRemoteDataSource
import io.reactivex.Single
import javax.inject.Inject

class SearchListRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchListRepository {
    override fun getSearch(query: String, page: Int): Single<SearchData> {
        return searchRemoteDataSource
            .getSearch(query, page)

    }

}