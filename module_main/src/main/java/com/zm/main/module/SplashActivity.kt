package com.zm.main.module

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.zm.main.R

/**
 * 闪屏页
 * <p>
 * Create by zm on 2018/12/27
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        jumpMain()
    }

    private fun jumpMain() {
        Handler().postDelayed({
            if (!isFinishing) {
                MainActivity.actionStart(baseContext)
                finish()
            }
        }, 1500)
    }
}
