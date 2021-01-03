package com.madderate.justbills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madderate.justbills.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        initView()
    }

    private fun initView() {
        mainBinding.mainToolbar.title = "justBills"
        setSupportActionBar(mainBinding.mainToolbar)
    }
}