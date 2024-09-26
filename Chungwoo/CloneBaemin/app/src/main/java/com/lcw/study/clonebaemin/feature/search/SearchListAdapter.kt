package com.lcw.study.clonebaemin.feature.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lcw.study.clonebaemin.R
import com.lcw.study.clonebaemin.data.search.Restaurant
import com.lcw.study.clonebaemin.data.search.SearchData
import com.lcw.study.clonebaemin.databinding.ItemSearchListBinding

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.SearchListViewHolder>() {
    private val searchList: ArrayList<SearchData> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchListViewHolder {
        val binding = DataBindingUtil.inflate<ItemSearchListBinding>(
            LayoutInflater.from(parent.context),
                R.layout.item_search_list, parent, false)

        return SearchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchListAdapter.SearchListViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int  = searchList.size

    fun setItem(items: List<SearchData>) {
        searchList.clear()
        searchList.addAll(items)
        notifyDataSetChanged()
    }

    inner class SearchListViewHolder(private val binding: ItemSearchListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(searchData: SearchData) {
            binding.data = searchData
            binding.executePendingBindings()
        }

    }
}