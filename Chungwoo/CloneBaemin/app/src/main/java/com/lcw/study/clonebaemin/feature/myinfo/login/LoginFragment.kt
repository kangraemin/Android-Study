package com.lcw.study.clonebaemin.feature.myinfo.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.lcw.study.clonebaemin.R
import com.lcw.study.clonebaemin.data.local.AppDatabase
import com.lcw.study.clonebaemin.data.local.TokenData
import com.lcw.study.clonebaemin.databinding.FragmentLoginBinding
import com.lcw.study.clonebaemin.feature.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = loginViewModel

        val db = AppDatabase.getInstance(requireContext())


        loginViewModel.loginData.observe(viewLifecycleOwner) {
            Log.d("LoginFragment", "value : $it")
            db.tokenDao().insert(TokenData(it.refresh, it.access))
                .subscribeOn(io())
                //.observeOn(AndroidSchedulers.mainThread())
                //.subscribe()
        }
    }
}