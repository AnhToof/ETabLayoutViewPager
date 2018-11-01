package com.example.toof.etablayout_viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.addTab(tab_layout.newTab().setText("FIRST").setIcon(R.drawable.ic_launcher_foreground))
        tab_layout.addTab(tab_layout.newTab().setText("SECOND").setIcon(R.drawable.ic_launcher_foreground))
        tab_layout.addTab(tab_layout.newTab().setText("THIRD").setIcon(R.drawable.ic_launcher_foreground))
        view_pager.adapter = PagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }

    class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        override fun getItem(p0: Int): Fragment = when (p0) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThridFragment()
        }

        override fun getCount(): Int = 3

        override fun getPageTitle(position: Int): CharSequence? = when (position) {
            0 -> "FIRST"
            1 -> "SECOND"
            else -> "THIRD"
        }
    }
}
