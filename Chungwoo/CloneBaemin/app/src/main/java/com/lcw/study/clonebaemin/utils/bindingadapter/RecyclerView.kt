package com.lcw.study.clonebaemin.utils.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lcw.study.clonebaemin.data.search.Restaurant
import com.lcw.study.clonebaemin.data.search.SearchData
import com.lcw.study.clonebaemin.feature.search.SearchListAdapter

@BindingAdapter("setSearchItem") // 검색 목록
fun RecyclerView.setSearchItem(searchItem: List<SearchData>?) {
    searchItem?.let { searchItem ->
        (adapter as SearchListAdapter).setItem(searchItem)
    }
}