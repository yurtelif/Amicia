package com.yrtelf.amicia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yrtelf.amicia.databinding.FragmentMainViewPagerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainViewPagerBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPager
        val bottomNavigation = binding.bottomNavigation

        return binding.root
    }
}
