package com.zm.common.router

/**
 * Created by zm on 2018/12/26.
 */
class RouterActivityPath {
    /**
     * 主页组件
     */
    object Main{
        private const val MAIN: String = "/main"
        /*主页*/
        const val PAGER_MAIN: String = "$MAIN/Main"
        /*登陆*/
        const val PAGER_LOGIN: String = "$MAIN/Login"
    }

}