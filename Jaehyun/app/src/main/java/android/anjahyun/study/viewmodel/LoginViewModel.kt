package android.anjahyun.study.viewmodel

import android.anjahyun.study.base.BaseViewModel
import android.anjahyun.study.data.local.Token
import android.anjahyun.study.data.local.TokenDao
import android.anjahyun.study.repository.LoginRepository
import android.anjahyun.study.util.SingleLiveEvent
import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository, private val tokenDao: TokenDao): BaseViewModel() {

    private var _loginResult = SingleLiveEvent<Boolean>()
    val loginResult : SingleLiveEvent<Boolean> get() = _loginResult

    fun login(id: String, pw: String) {
        repository.login(id, pw)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccessful) {
                    if (it.code() == 200) {
                        _loginResult.postValue(true)
                        val accessToken = it.body()?.get("access")
                        val refreshToken = it.body()?.get("refresh")
                        if (accessToken != null && refreshToken != null) {
                            tokenDao.insertToken(Token(accessToken.asString, refreshToken.asString))
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe()
                        }
                    }
                    else _loginResult.postValue(false)
                }
                else _loginResult.postValue(false)
            }, {
                _loginResult.postValue(false)
            })
    }
}