package android.anjahyun.study.view.orderlist

import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentOrderlistShoppingliveBinding
import android.anjahyun.study.viewmodel.FavViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels

class OrderListShoppingLiveFragment: BaseFragment<FragmentOrderlistShoppingliveBinding>(FragmentOrderlistShoppingliveBinding::inflate) {

    private val viewModel: FavViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}