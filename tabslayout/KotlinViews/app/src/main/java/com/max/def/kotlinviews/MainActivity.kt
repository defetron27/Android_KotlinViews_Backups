package com.max.def.kotlinviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import github.chenupt.springindicator.SpringIndicator

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val indicator : SpringIndicator = findViewById(R.id.indicator)
        val viewPager : ViewPager = findViewById(R.id.view_pager)

        viewPager.adapter = TabAdapter(supportFragmentManager)

        indicator.setViewPager(viewPager)
    }
}
