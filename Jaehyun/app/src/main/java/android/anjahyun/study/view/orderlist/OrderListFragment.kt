package android.anjahyun.study.view.orderlist

import android.anjahyun.study.R
import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentOrderlistBinding
import android.anjahyun.study.view.fav.FavViewPagerAdapter
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator

class OrderListFragment: BaseFragment<FragmentOrderlistBinding>(FragmentOrderlistBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = OrderListViewPagerAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            when(position) {
                0 -> tab.text = resources.getString(R.string.orderList1)
                1 -> tab.text = resources.getString(R.string.orderList2)
                2 -> tab.text = resources.getString(R.string.orderList3)
                3 -> tab.text = resources.getString(R.string.orderList4)
            }
        }.attach()
    }

}