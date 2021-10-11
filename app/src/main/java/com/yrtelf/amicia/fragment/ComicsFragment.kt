package com.yrtelf.amicia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yrtelf.amicia.adapter.ComicsAdapter
import com.yrtelf.amicia.databinding.FragmentComicsBinding
import com.yrtelf.amicia.viewModel.ComicsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class ComicsFragment : Fragment() {

    private val viewModel: ComicsViewModel by viewModels()
    private lateinit var binding: FragmentComicsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicsBinding.inflate(inflater, container, false)
        val adapter = ComicsAdapter()
        binding.rvComics.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.comics.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }

        return binding.root
    }
}
