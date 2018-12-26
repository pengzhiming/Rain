package com.zm.common.base

import android.app.Application

/**
 * Created by zm on 2018/12/26.
 */
interface IModuleInit {
    // 初始化优先的
    fun onInitAhead(application: Application): Boolean
    // 初始化靠后的
    fun onInitLow(application: Application): Boolean
}