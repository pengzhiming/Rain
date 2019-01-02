package com.zm.common.manager

import android.app.Activity
import android.util.Log
import java.lang.Exception
import java.util.*

/**
 * Created by zm on 2018/12/28.
 * <p>
 * activity堆栈式管理
 */
class AppManager private constructor(){

    // 双重校验单例模式
    companion object {
        val instance: AppManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AppManager()
        }
    }

    // Activity栈
    private var activityStack: Stack<Activity>? = null

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        if (activityStack == null) {
            activityStack = Stack()
        }
        activityStack?.push(activity)
    }

    /**
     * 结束指定的Activity
     */
     fun finishActivity(activity: Activity?) {
        if (activity != null) {
            activity.finish()
            activityStack?.remove(activity)
        }
    }

    /**
     * 结束当前Activity(堆栈中最后一个压入的)
     */
    fun finishtCurActivity() {
        finishActivity(activityStack?.lastElement())
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        activityStack?.let {
            it.forEach { activity ->
                activity.finish()
            }
            it.clear()
        }
    }

    /**
     * 获取当前Activity堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        return activityStack?.lastElement()
    }

    /**
     * 退出应用程序
     */
    fun appExit() {
       try {
           finishAllActivity()
           android.os.Process.killProcess(android.os.Process.myPid())
           System.exit(0)
       }catch (e: Exception) {
           Log.e(AppManager::class.java.name, e.message, e)
       }
    }
}