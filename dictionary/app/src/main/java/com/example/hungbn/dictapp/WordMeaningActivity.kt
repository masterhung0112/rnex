package com.example.hungbn.dictapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.example.hungbn.dictapp.fragments.FragmentAntonyms
import com.example.hungbn.dictapp.fragments.FragmentDefinition
import com.example.hungbn.dictapp.fragments.FragmentExample
import com.example.hungbn.dictapp.fragments.FragmentSynonyms

class WordMeaningActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_meaning)

        var toolbar = findViewById<Toolbar>(R.id.mToolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "English Words"

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        viewPager = findViewById<ViewPager>(R.id.tab_viewpager)
        setupViewPager(viewPager)

        var tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {

                }

                override fun onTabReselected(tab: TabLayout.Tab) {

                }
            }
        )
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
            onBackPressed()

        return super.onOptionsItemSelected(item)
    }

    private class ViewPageAdapter(fm: FragmentManager?): FragmentPagerAdapter(fm) {
        private final var mFragmentList: MutableList<Fragment> = mutableListOf<Fragment>()
        private final var mFragmentTitleList: MutableList<String> = mutableListOf<String>()

        public override fun getItem(p0: Int): Fragment {
            return mFragmentList.get(p0)
        }

        public override fun getCount(): Int {
            return mFragmentList.size
        }

        public fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        public override fun getPageTitle(position: Int) : CharSequence {
            return mFragmentTitleList.get(position)
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFrag(FragmentDefinition(), "Definition")
        adapter.addFrag(FragmentSynonyms(), "Synonyms")
        adapter.addFrag(FragmentAntonyms(), "Antonyms")
        adapter.addFrag(FragmentExample(), "Example")
        viewPager.adapter = adapter
    }
}
