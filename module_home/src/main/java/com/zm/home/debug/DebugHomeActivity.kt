package com.zm.home.debug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zm.home.R
import com.zm.home.module.HomeFragment

/**
 * Created by zm on 2018/12/25.
 */
class DebugHomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_home)
        setFragment()
    }

    // 设置Fragment
    private fun setFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, HomeFragment.newInstance()).commit()
    }
}