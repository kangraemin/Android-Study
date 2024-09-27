package android.anjahyun.study.view.search

import android.anjahyun.study.R
import android.anjahyun.study.base.BaseFragment
import android.anjahyun.study.data.local.Search
import android.anjahyun.study.data.remote.Restaurant
import android.anjahyun.study.databinding.FragmentSearchBinding
import android.anjahyun.study.viewmodel.SearchViewModel
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import org.intellij.lang.annotations.Language
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val viewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var searchRecentAdapter: SearchRecentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchAdapter = SearchAdapter({searchDetail(it)}, {deleteItem(it)})
        binding.recyclerViewSearch.adapter = searchAdapter

        searchRecentAdapter = SearchRecentAdapter({clickRecent(it)}, {deleteSearch(it)})
        binding.recyclerViewRecent.adapter = searchRecentAdapter


        val now = System.currentTimeMillis()
        val nowTime = Date(now)
        val sdf = SimpleDateFormat("MM.dd HH")
        val time = sdf.format(nowTime)
        val viewTime = "$time:00 ${resources.getString(R.string.search4)}"

        binding.tvNow.text = viewTime

        viewModel.searchList.observe(viewLifecycleOwner, {
            searchAdapter.submitList(it)
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText?:"")
                return true
            }

        })

    }

    private fun searchDetail(item: Restaurant) {
        val action = SearchFragmentDirections.actionSearchFragmentToSearchDetailFragment(item.name)
        findNavController().navigate(action)
    }

    private fun deleteItem(item: Restaurant) {

    }

    private fun clickRecent(item: Search) {

    }

    private fun deleteSearch(item: Search) {

    }



}