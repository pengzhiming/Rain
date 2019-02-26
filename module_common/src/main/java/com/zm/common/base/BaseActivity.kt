package com.zm.common.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import java.lang.reflect.ParameterizedType

/**
 * 一个拥有DataBinding框架的基Activity
 * <p>
 * Created by zm on 2019/2/25.
 */
abstract class BaseActivity<V: ViewDataBinding, VM: BaseViewModel> : RxAppCompatActivity(), IBaseActivity{
    protected lateinit var binding: V
    protected var viewModel: VM? = null
    private var viewModelId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 页面接受的参数方法
        initParam()
        // 私有的ViewModel与View的契约事件回调逻辑
        initViewDataBinding(savedInstanceState)
        // 页面数据初始化方法
        initData()
        //TODO 页面事件监听的方法，一般用于ViewModel层转到View层的事件注册
        // 注册RxBus
        viewModel?.registerRxBus()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.let {
            // 解除ViewModel生命周期感应
            lifecycle.removeObserver(it)
            // 移除RxBus
            it.removeRxBus()
        }
        // 解除绑定
        binding.unbind()
    }

    /**
     * 注入绑定
     */
    @Suppress("UNCHECKED_CAST")
    private fun initViewDataBinding(savedInstanceState: Bundle?) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        binding = DataBindingUtil.setContentView(this, initContentViewId(savedInstanceState))
        viewModelId = initVariableId()
        viewModel = initViewModel()
        if (null == viewModel) {
            val type = javaClass.genericSuperclass as ParameterizedType
            val  modelClass = type.actualTypeArguments[1] as Class<VM>
            viewModel = createViewModel(this, modelClass)
        }
        viewModel?.let {
           // 关联ViewModel
           binding.setVariable(viewModelId, it)
           // 让ViewModel拥有View的生命周期感应
           lifecycle.addObserver(it)
           //注入RxLifecycle生命周期
           it.injectLifecycleProvider(this)
       }
    }

    /**
     * =============================================================================================
     **/
    override fun initParam() {
    }

    /**
     * 初始化根布局
     * @return 布局layout的id
     */
    abstract fun initContentViewId(savedInstanceState: Bundle?): Int

    /**
     * 初始化ViewModel的id
     * @return BR的id
     */
    abstract fun initVariableId(): Int

    /**
    * 初始化ViewModel
    * @return 继承BaseViewModel的ViewModel
    */
    open fun initViewModel(): VM? {
        return null
    }

    override fun initData() {
    }

    override fun initViewObservable() {
    }

    /**
     * 创建ViewModel
     * @param activity
     * @param cls
     * @return
     */
    private fun <T: ViewModel> createViewModel(activity: FragmentActivity, cls: Class<T>): T {
        return ViewModelProviders.of(activity).get(cls)
    }
}