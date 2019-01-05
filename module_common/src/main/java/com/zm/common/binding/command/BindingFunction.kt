package com.zm.common.binding.command

/**
 * 零参数有返回值函数
 * <p>
 * Created by zm on 2019/1/5.
 */
interface BindingFunction<T> {
    fun call(): T
}