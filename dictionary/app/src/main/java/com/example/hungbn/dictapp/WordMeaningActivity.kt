package com.example.hungbn.dictapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem

class WordMeaningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_meaning)

        var toolbar = findViewById<Toolbar>(R.id.mToolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "English Words"

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
            onBackPressed()

        return super.onOptionsItemSelected(item)
    }
}
