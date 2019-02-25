package com.zm.common.base

/**
 * Created by zm on 2019/2/25.
 */
interface IBaseActivity {
    /**
     * 初始化界面参数
     */
    fun initParam()

    /**
     * 初始化数据
     */
    fun initData()

    /**
     * 初始化界面观察者的监听
     */
    fun initViewObservable()
}