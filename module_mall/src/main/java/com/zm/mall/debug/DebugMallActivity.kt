package com.zm.mall.debug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zm.mall.R
import com.zm.mall.module.MallFragment

/**
 * Created by zm on 2018/12/25.
 */
class DebugMallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_mall)
        setFragment()
    }

    // 设置Fragment
    private fun setFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, MallFragment.newInstance())
                .commit()
    }
}