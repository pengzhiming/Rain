package com.zm.common.utils

import android.annotation.SuppressLint
import android.widget.Toast
import com.zm.common.Common

/**
 * 吐司工具类
 * 简单实用
 * <p>
 * Created by zm on 2019/2/24.
 */
object ToastUtils {

    @SuppressLint("ShowToast")
    fun showToast(message: String) {
        Common.getApplication()?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT)
        }
    }
}