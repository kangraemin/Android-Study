package android.anjahyun.study.view.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = 6

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MainDeliveryFragment()
            1 -> MainBaemin1Fragment()
            2 -> MainTakeoutFragment()
            3 -> MainShoppingLiveFragment()
            4 -> MainGiftFragment()
            else -> MainDeliciousFragment()
        }
    }

}