package com.lcw.study.clonebaemin.feature.myinfo.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lcw.study.clonebaemin.data.login.LoginData
import com.lcw.study.clonebaemin.data.login.repository.LoginRepository
import com.lcw.study.clonebaemin.feature.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : BaseViewModel() {

    private val _success: MutableLiveData<Boolean> = MutableLiveData()
    val success: LiveData<Boolean> get() = _success

    private val _loginData: MutableLiveData<LoginData> = MutableLiveData()
    val loginData: LiveData<LoginData> get() = _loginData


    fun requestLogin(userName: String, password: String) {
        loginRepository.requestLogin(username = userName, password = password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("LoginViewmodel", "response success: $it ")
                _loginData.postValue(it)
            }, {
                Log.d("LoginViewmodel", "response fail: $it ")
            })
    }
}