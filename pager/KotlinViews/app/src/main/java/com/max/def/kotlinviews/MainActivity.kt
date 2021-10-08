package com.max.def.kotlinviews

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.ToxicBakery.viewpager.transforms.*

class MainActivity : AppCompatActivity()
{
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        viewPager = findViewById(R.id.view_pager)

        viewPager.adapter = TabAdapter(supportFragmentManager)

        tabLayout.setupWithViewPager(viewPager);

        refreshViewPager();
    }

    override fun onResume()
    {
        super.onResume()

        refreshViewPager()
    }

    private fun refreshViewPager()
    {
        val transform = SettingsActivity.getTransformer(this)

        when(transform)
        {
            "DefaultTransformer" -> viewPager.setPageTransformer(true,DefaultTransformer())
            "AccordionTransformer" -> viewPager.setPageTransformer(true, AccordionTransformer())
            "BackgroundToForegroundTransformer" -> viewPager.setPageTransformer(true, BackgroundToForegroundTransformer())
            "CubeInTransformer" -> viewPager.setPageTransformer(true,CubeInTransformer())
            "CubeOutTransformer" -> viewPager.setPageTransformer(true,CubeOutTransformer())
            "DepthPageTransformer" -> viewPager.setPageTransformer(true, DepthPageTransformer())
            "DrawerTransformer" -> viewPager.setPageTransformer(true,object : ABaseTransformer()
            {
                override fun onTransform(page: View, position: Float)
                {
                    if(position <= 0)
                    {
                        page.translationX = 0F
                    }
                    else if (position <= 1)
                    {
                        page.translationX = page.width * 2 / position
                    }
                }
            })
            "FlipHorizontalTransformer" -> viewPager.setPageTransformer(true,FlipHorizontalTransformer())
            "FlipVerticalTransformer" -> viewPager.setPageTransformer(true,FlipVerticalTransformer())
            "ForegroundToBackgroundTransformer" -> viewPager.setPageTransformer(true,ForegroundToBackgroundTransformer())
            "RotateDownTransformer" -> viewPager.setPageTransformer(true,RotateDownTransformer())
            "RotateUpTransformer" -> viewPager.setPageTransformer(true,RotateUpTransformer())
            "ScaleInOutTransformer" -> viewPager.setPageTransformer(true,ScaleInOutTransformer())
            "StackTransformer" -> viewPager.setPageTransformer(true,StackTransformer())
            "TabletTransformer" -> viewPager.setPageTransformer(true,TabletTransformer())
            "ZoomInTransformer" -> viewPager.setPageTransformer(true,ZoomInTransformer())
            "ZoomOutSlideTransformer" -> viewPager.setPageTransformer(true, ZoomOutSlideTransformer())
            "ZoomOutTransformer" -> viewPager.setPageTransformer(true,object:ABaseTransformer()
            {
                override fun onTransform(page: View, position: Float)
                {
                    val scale = 1f + Math.abs(position)

                    page.scaleX = scale
                    page.scaleY = scale

                    page.pivotX = page.width * .5f
                    page.pivotY = page.height * .5f

                    page.alpha = if(position < -1f || position > 1f) 0f else 1f - (scale -1f)

                    if (position == -1f)
                    {
                        page.translationX = page.width * -1f
                    }

                }
            })
            else -> viewPager.setPageTransformer(true,DefaultTransformer())

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.menu_main,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val id = item.itemId

        if(id == R.id.setting)
        {
            startActivity(Intent(this,SettingsActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}

