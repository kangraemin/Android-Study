package com.lcw.study.clonebaemin.data.search

import io.reactivex.Single

interface SearchListRepository {
    fun getSearch(query: String, page: Int): Single<SearchData>
}