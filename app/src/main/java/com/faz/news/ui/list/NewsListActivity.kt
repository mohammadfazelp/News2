package com.faz.news.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faz.news.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}