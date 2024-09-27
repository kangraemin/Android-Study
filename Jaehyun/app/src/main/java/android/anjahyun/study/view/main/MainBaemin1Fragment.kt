package android.anjahyun.study.view.main

import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentMainBaemin1Binding
import android.anjahyun.study.viewmodel.MainViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels

class MainBaemin1Fragment: BaseFragment<FragmentMainBaemin1Binding>(FragmentMainBaemin1Binding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}