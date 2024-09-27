package android.anjahyun.study.viewmodel

import android.anjahyun.study.base.BaseViewModel
import android.anjahyun.study.repository.MainRepository
import android.anjahyun.study.repository.SharedRepository
import android.anjahyun.study.util.SingleLiveEvent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.room.EmptyResultSetException
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: SharedRepository): BaseViewModel() {

    /**
     * 공용 변수
     * isMember : 로그인 여부를 파악한다(기본 자동로그인이라고 가정)
     */
    private var _isMember = SingleLiveEvent<Boolean>()
    val isMember : SingleLiveEvent<Boolean> get() = _isMember

    init {
        checkAccessToken()
    }

    fun checkAccessToken() {
        addDisposable(
            repository.checkAccessToken()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (!it.isNullOrEmpty()) _isMember.postValue(true)
                    else _isMember.postValue(false)
                }, {
                    if (it is EmptyResultSetException) {
                        _isMember.postValue(false)
                    }
                    else {
                        _isMember.postValue(false)
                    }
                })
        )
    }




}