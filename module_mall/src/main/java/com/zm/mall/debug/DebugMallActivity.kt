package com.zm.mall.debug

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.zm.mall.R

/**
 * Created by zm on 2018/12/25.
 */
class DebugMallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_debug_mall)
    }
}