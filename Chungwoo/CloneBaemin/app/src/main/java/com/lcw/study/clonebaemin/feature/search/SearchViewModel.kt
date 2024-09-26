package com.lcw.study.clonebaemin.feature.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lcw.study.clonebaemin.data.search.SearchData
import com.lcw.study.clonebaemin.data.search.SearchListRepository
import com.lcw.study.clonebaemin.feature.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchListRepository: SearchListRepository) : BaseViewModel() {

    private val _success: MutableLiveData<Boolean> = MutableLiveData()
    val success: LiveData<Boolean> get() = _success

    val _searchData: MutableLiveData<SearchData> = MutableLiveData()
    val searchData: LiveData<SearchData> get() = _searchData


    fun getSearch( query: String, page: Int) {
        searchListRepository.getSearch(query, page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("SearchListViewModel", "response success: ${it.restaurants} ")
                _searchData.postValue(it)
            }, {
                Log.d("SearchListViewModel", "response fail: $it ")

            })



    }
}