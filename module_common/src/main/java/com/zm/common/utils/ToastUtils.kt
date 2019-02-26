package com.zm.common.utils

import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.dovar.dtoast.DToast
import com.zm.common.Common
import com.zm.common.R

/**
 * 吐司工具类
 * 简单实用
 * <p>
 * Created by zm on 2019/2/24.
 */
object ToastUtils {

    fun show(message: String?) {
        Common.getApplication()?.let {
            val toast = DToast.make(it)
            val tvText = toast.view.findViewById<TextView>(R.id.tv_content)
            tvText?.text = message
            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0, 30).show()
        }
    }

    fun showAtCenter(message: String?) {
        Common.getApplication()?.let {
            val toastRoot = View.inflate(it, R.layout.layout_toast_center, null)
            val tvText = toastRoot.findViewById<TextView>(R.id.tv_content)
            tvText?.text = message
            DToast.make(it).setView(toastRoot).setGravity(Gravity.CENTER, 0, 0).show()
        }
    }

    /**
     * 退出APP时调用
     */
    fun cancelAll() {
        DToast.cancel()
    }
}