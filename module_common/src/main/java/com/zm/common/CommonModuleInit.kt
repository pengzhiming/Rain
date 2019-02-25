package com.zm.common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.zm.common.base.IModuleInit

/**
 * Created by zm on 2018/12/26.
 */
class CommonModuleInit : IModuleInit {

    override fun onInit(application: Application): Boolean {
        // init Common
        Common.init(application)
        // init ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(application)
        return false
    }

}