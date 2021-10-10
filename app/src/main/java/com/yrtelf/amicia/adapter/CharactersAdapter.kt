package com.yrtelf.amicia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yrtelf.amicia.data.character.CharacterResult
import com.yrtelf.amicia.databinding.ItemCharecterViewBinding

class CharactersAdapter : PagingDataAdapter<CharacterResult, CharactersAdapter.CharacterViewHolder>(
    CHARACTRER_COMPARATOR
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharecterViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val repoItem = getItem(position)
        holder.bind(repoItem)
    }

    class CharacterViewHolder(
        private val binding: ItemCharecterViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(characterResult: CharacterResult?) {
            binding.apply {
                character = characterResult
                executePendingBindings()
            }
        }
    }
}

val CHARACTRER_COMPARATOR = object : DiffUtil.ItemCallback<CharacterResult>() {
    override fun areItemsTheSame(oldItem: CharacterResult, newItem: CharacterResult): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CharacterResult, newItem: CharacterResult): Boolean =
        oldItem == newItem
}
