package com.zm.main.module.login

import android.app.Application
import android.databinding.ObservableField
import android.text.TextUtils
import android.view.View
import com.zm.common.base.BaseViewModel
import com.zm.common.utils.ToastUtils
import io.reactivex.annotations.NonNull

/**
 * Created by zm on 2019/2/24.
 */
class LoginViewModel(@NonNull application: Application) : BaseViewModel(application){
    // 用户名的绑定
    var userName: ObservableField<String> = ObservableField("")
    // 密码的绑定
    var password: ObservableField<String> = ObservableField("")

    // 登录按钮的点击事件
    var loginClick: View.OnClickListener = View.OnClickListener {
        login()
    }

    /**
     * 网络模拟一个登陆操作
     */
    private fun login() {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.show("请输入账号！")
            return
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.show("请输入密码！")
            return
        }
        //TODO RxJava模拟一个延迟操作
    }
}