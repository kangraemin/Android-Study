package android.anjahyun.study.view.main

import android.anjahyun.study.R
import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentMainBinding
import android.anjahyun.study.view.orderlist.OrderListViewPagerAdapter
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = MainViewPagerAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            when(position) {
                0 -> tab.text = resources.getString(R.string.main1)
                1 -> tab.text = resources.getString(R.string.main2)
                2 -> tab.text = resources.getString(R.string.main3)
                3 -> tab.text = resources.getString(R.string.main4)
                4 -> tab.text = resources.getString(R.string.main5)
                5 -> tab.text = resources.getString(R.string.main6)
            }
        }.attach()
    }

}