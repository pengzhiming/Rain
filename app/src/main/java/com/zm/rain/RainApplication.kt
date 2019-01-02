package com.zm.rain

import android.app.Application
import com.zm.common.CommonModuleInit
import com.zm.home.HomeModuleInit
import com.zm.main.MainModuleInit
import com.zm.mall.MallModuleInit
import com.zm.mine.MineModuleInit
import com.zm.msg.MsgModuleInit

/**
 * Created by zm on 2018/12/25.
 */
class RainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CommonModuleInit().onInit(this)
        MainModuleInit().onInit(this)
        HomeModuleInit().onInit(this)
        MallModuleInit().onInit(this)
        MsgModuleInit().onInit(this)
        MineModuleInit().onInit(this)
    }
}