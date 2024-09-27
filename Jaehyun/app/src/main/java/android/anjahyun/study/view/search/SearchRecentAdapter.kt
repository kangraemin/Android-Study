package android.anjahyun.study.view.search

import android.anjahyun.study.data.local.Search
import android.anjahyun.study.databinding.ItemSearchRecentBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SearchRecentAdapter(val searchClick: (Search) -> Unit, val deleteClick: (Search) -> Unit):
ListAdapter<Search, SearchRecentAdapter.ViewHolder>(SearchRecentDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecentAdapter.ViewHolder {
        return ViewHolder(
            ItemSearchRecentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchRecentAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSearchRecentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Search) {
            binding.item = item
        }
    }

}

private class SearchRecentDiffCallback: DiffUtil.ItemCallback<Search>() {
    override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
        return oldItem == newItem
    }
}