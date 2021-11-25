package com.clonecodingbm.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clonecodingbm.data.remote.base.BaseNetworkCallResult
import com.clonecodingbm.data.remote.login.LoginRequest
import com.clonecodingbm.data.repository.login.LoginRepository
import com.clonecodingbm.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : BaseViewModel() {
    private val _loginResult: MutableLiveData<Boolean> = MutableLiveData()
    val loginResult: LiveData<Boolean> get() = _loginResult

    fun doLoginRequest(id: String, password: String) {
        compositeDisposable.add(
            repository
                .login(LoginRequest(id, password))
                .andThen(Single.just(BaseNetworkCallResult<Unit>()))
                .onErrorReturn{ BaseNetworkCallResult(throwable = it)}
                .doOnSubscribe { showProgress() }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate{ hideProgress() }
                .subscribe({
                    _loginResult.value = true
                }, {
                    it.printStackTrace()
                    _loginResult.value = false
                })
        )
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}