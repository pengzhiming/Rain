package com.zm.common.base

import android.app.Application

/**
 * Created by zm on 2018/12/26.
 * <p>
 *  配置Application，有需要初始化的组件实现该接口，统一在主app的Application中初始化
 */
interface IModuleInit {
    // 初始化
    fun onInit(application: Application): Boolean
}