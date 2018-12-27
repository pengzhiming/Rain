package com.zm.common.base

import android.app.Application

/**
 * Created by zm on 2018/12/26.
 */
interface IModuleInit {
    // 初始化优先的
    fun onInit(application: Application): Boolean
}