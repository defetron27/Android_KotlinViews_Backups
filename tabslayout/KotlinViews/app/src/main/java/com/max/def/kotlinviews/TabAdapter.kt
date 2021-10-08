package com.max.def.kotlinviews

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TabAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm)
{
    override fun getItem(p0: Int): Fragment?
    {
        return when(p0)
        {
            0->BlankFragment()
            1->BlankFragment2()
            2->BlankFragment3()
            else->null
        }
    }

    override fun getCount(): Int {
      return 3;
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return when(position)
        {
            0->"1"
            1->"2"
            2->"3"
            else->""
        }
    }

}