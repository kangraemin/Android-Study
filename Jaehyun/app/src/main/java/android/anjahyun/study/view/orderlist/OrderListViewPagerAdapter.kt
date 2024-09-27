package android.anjahyun.study.view.orderlist

import android.anjahyun.study.view.fav.FavBmartFragment
import android.anjahyun.study.view.fav.FavShoppingLiveFragment
import android.anjahyun.study.view.fav.FavTakeoutFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OrderListViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OrderListTakeoutFragment()
            1 -> OrderListBmartFragment()
            2 -> OrderListShoppingLiveFragment()
            else -> OrderListDeliciousFragment()
        }
    }

}