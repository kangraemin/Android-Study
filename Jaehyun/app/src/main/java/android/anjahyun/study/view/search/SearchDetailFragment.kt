package android.anjahyun.study.view.search

import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentSearchDetailBinding
import android.anjahyun.study.viewmodel.SearchViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchDetailFragment: BaseFragment<FragmentSearchDetailBinding>(FragmentSearchDetailBinding::inflate) {

    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}