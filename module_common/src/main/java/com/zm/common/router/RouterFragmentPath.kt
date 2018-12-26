package com.zm.common.router

/**
 * Created by zm on 2018/12/26.
 */
class RouterFragmentPath {
    /**
     * 首页组件
     */
    object Home{
        private const val HOME: String = "/home"
        /*首页*/
        const val PAGER_HOME: String = "$HOME/Home"
    }

    /**
     * 商城组件
     */
    object Mall{
        private const val MALL: String = "/mall"
        /*首页*/
        const val PAGER_MALL: String = "$MALL/Mall"
    }

    /**
     * 消息组件
     */
    object Msg{
        private const val MSG: String = "/msg"
        /*首页*/
        const val PAGER_MSG: String = "$MSG/Msg"
    }

    /**
     * 用户组件
     */
    object User{
        private const val USER: String = "/user"
        /*首页*/
        const val PAGER_USER: String = "$USER/Mine"
    }
}