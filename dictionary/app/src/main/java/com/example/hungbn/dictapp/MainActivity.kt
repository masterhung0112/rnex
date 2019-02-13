package com.example.hungbn.dictapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    lateinit var search : SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        search = findViewById(R.id.search_view)
        search.setOnClickListener {
            search.setIconifiedByDefault(false)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null)
            menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.action_settings -> return true
            R.id.action_exit -> {
                System.exit(0)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
