package android.anjahyun.study.view.search

import android.anjahyun.study.data.remote.Restaurant
import android.anjahyun.study.databinding.ItemSearchBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(val searchClick: (Restaurant) -> Unit, val deleteClick: (Restaurant) -> Unit):
    ListAdapter<Restaurant, SearchAdapter.ViewHolder>(SearchDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        return ViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSearchBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Restaurant) {
            binding.item = item
            binding.root.setOnClickListener { searchClick(item) }
            binding.btnDelete.setOnClickListener { deleteClick(item) }
        }
    }

}

private class SearchDiffCallback: DiffUtil.ItemCallback<Restaurant>() {
    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem == newItem
    }
}
