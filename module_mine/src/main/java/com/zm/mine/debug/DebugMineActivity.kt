package com.zm.mine.debug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zm.mine.R
import com.zm.mine.module.MineFragment

/**
 * Created by zm on 2018/12/25.
 */
class DebugMineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_mine)
        setFragment()
    }

    // 设置Fragment
    private fun setFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, MineFragment.newInstance())
                .commit()
    }
}