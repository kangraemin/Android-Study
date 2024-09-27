package android.anjahyun.study.viewmodel

import android.anjahyun.study.base.BaseViewModel
import android.anjahyun.study.data.local.TokenDao
import android.anjahyun.study.repository.MainRepository
import android.anjahyun.study.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository, private val tokenDao: TokenDao): BaseViewModel() {


}