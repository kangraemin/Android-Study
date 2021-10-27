package android.anjahyun.study.view.orderlist

import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentFavBinding
import android.anjahyun.study.databinding.FragmentFavBmartBinding
import android.anjahyun.study.databinding.FragmentOrderlistTakeoutBinding
import android.anjahyun.study.viewmodel.FavViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels

class OrderListTakeoutFragment: BaseFragment<FragmentOrderlistTakeoutBinding>(FragmentOrderlistTakeoutBinding::inflate) {

    private val viewModel: FavViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}