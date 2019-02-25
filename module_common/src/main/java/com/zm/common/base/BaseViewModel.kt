package com.zm.common.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.annotations.NonNull

/**
 * Created by zm on 2019/2/25.
 */
open class BaseViewModel(@NonNull application: Application): AndroidViewModel(application),  IBaseViewModel{
    private lateinit var lifecycleProvider: LifecycleProvider<ActivityEvent>

    /**
     * 注入RxLifecycle生命周期
     * @param lifecycle
     */
    fun injectLifecycleProvider(lifecycleProvider: LifecycleProvider<ActivityEvent>) {
        this.lifecycleProvider = lifecycleProvider
    }

    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun registerRxBus() {
    }

    override fun removeRxBus() {
    }
}