package com.zm.main.module.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.zm.common.base.BaseActivity
import com.zm.common.router.RouterActivityPath
import com.zm.main.BR
import com.zm.main.R
import com.zm.main.databinding.LoginBinding

/**
 * 登陆页
 * <p>
 * Create by zm on 2019/2/24.
 */
@Route(path = RouterActivityPath.Main.PAGER_LOGIN)
class LoginActivity : BaseActivity<LoginBinding, LoginViewModel>() {

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun initContentViewId(savedInstanceState: Bundle?): Int {
        return R.layout.activity_login
    }

    override fun initVariableId(): Int {
        return BR.viewModel
    }

    override fun initViewModel(): LoginViewModel? {
        // View持有ViewModel的引用，如果没有特殊业务处理，这个方法可以不重写
        return ViewModelProviders.of(this).get(LoginViewModel::class.java);
    }
}
