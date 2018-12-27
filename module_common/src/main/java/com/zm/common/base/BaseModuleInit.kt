package com.zm.common.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.zm.common.BuildConfig

/**
 * Created by zm on 2018/12/26.
 */
class BaseModuleInit : IModuleInit{
    override fun onInit(application: Application): Boolean {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(application)
        return false
    }

}