package com.yrtelf.amicia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yrtelf.amicia.data.comic.ComicResult
import com.yrtelf.amicia.databinding.ItemComicViewBinding
import com.yrtelf.amicia.fragment.ComicsFragmentDirections

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

        init {
            binding.setClickListener { view ->
                binding.comic?.id.let {
                    navigateToComicDetail(it!!, view)
                }
            }
        }

        fun bind(comicResult: ComicResult?) {
            binding.apply {
                comic = comicResult
                executePendingBindings()
            }
        }

        private fun navigateToComicDetail(comicId: Int, view: View) {
            val direction = ComicsFragmentDirections.actionComicToComicDetailFragment(comicId.toString())
            view.findNavController().navigate(direction)
        }
    }
}

val COMIC_COMPARATOR = object : DiffUtil.ItemCallback<ComicResult>() {
    override fun areItemsTheSame(oldItem: ComicResult, newItem: ComicResult): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ComicResult, newItem: ComicResult): Boolean =
        oldItem == newItem
}
