package com.yrtelf.amicia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yrtelf.amicia.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil.setContentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}
