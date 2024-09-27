package android.anjahyun.study.viewmodel

import android.anjahyun.study.base.BaseViewModel
import android.anjahyun.study.data.local.Search
import android.anjahyun.study.data.local.SearchDao
import android.anjahyun.study.data.local.Token
import android.anjahyun.study.data.local.TokenDao
import android.anjahyun.study.data.remote.Restaurant
import android.anjahyun.study.repository.SearchRepository
import android.anjahyun.study.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository, private val searchDao: SearchDao): BaseViewModel() {


    private var _searchList = SingleLiveEvent<List<Restaurant>>()
    val searchList : SingleLiveEvent<List<Restaurant>> get() = _searchList

    fun search(query: String) {
        val now = System.currentTimeMillis()
        val sdf = SimpleDateFormat("yyyyMMdd")
        val nowTime = sdf.format(Date(now))
        searchDao.insertSearch(Search(query, nowTime))
        repository.search(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    val list = arrayListOf<Restaurant>()
                    val data = it.body()
                    if (data?.restaurants?.size?:0 > 0) {
                        _searchList.postValue(data?.restaurants)
                    }
                    else _searchList.postValue(list)
                }
            }, {

            })
    }


}