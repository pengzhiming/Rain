package com.zm.msg.debug

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.zm.msg.R
import com.zm.msg.module.MsgFragment

class DebugMsgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug_msg)
        setFragment()
    }

    // 设置Fragment
    private fun setFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_content, MsgFragment.newInstance())
                .commit()
    }
}
