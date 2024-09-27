package android.anjahyun.study.view.fav

import android.anjahyun.study.R
import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.databinding.FragmentFavBinding
import android.anjahyun.study.databinding.FragmentSearchDetailBinding
import android.anjahyun.study.databinding.FragmentSplashBinding
import android.anjahyun.study.viewmodel.FavViewModel
import android.anjahyun.study.viewmodel.SearchViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

class FavFragment: BaseFragment<FragmentFavBinding>(FragmentFavBinding::inflate) {

    private val viewModel: FavViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = FavViewPagerAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            when(position) {
                0 -> tab.text = resources.getString(R.string.fav1)
                1 -> tab.text = resources.getString(R.string.fav2)
                2 -> tab.text = resources.getString(R.string.fav3)
            }
        }.attach()

    }

}