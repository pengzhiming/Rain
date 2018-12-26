package com.zm.rain

import android.app.Application
import com.zm.common.base.BaseModuleInit

/**
 * Created by zm on 2018/12/25.
 */
class RainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化组件(靠前)
        BaseModuleInit().onInitAhead(this)
    }
}