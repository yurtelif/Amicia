package com.yrtelf.amicia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yrtelf.amicia.data.comic.ComicResult
import com.yrtelf.amicia.databinding.ItemComicViewBinding

class ComicsAdapter : PagingDataAdapter<ComicResult, ComicsAdapter.ComicViewHolder>(
    COMIC_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(ItemComicViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val repoItem = getItem(position)
        holder.bind(repoItem)
    }

    class ComicViewHolder(
        private val binding: ItemComicViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comicResult: ComicResult?) {
            binding.apply {
                comic = comicResult
                executePendingBindings()
            }
        }
    }
}

val COMIC_COMPARATOR = object : DiffUtil.ItemCallback<ComicResult>() {
    override fun areItemsTheSame(oldItem: ComicResult, newItem: ComicResult): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ComicResult, newItem: ComicResult): Boolean =
        oldItem == newItem
}
