package com.zm.common.binding.command

import io.reactivex.functions.Function

/**
 * 执行的命令事件转换
 * <p>
 * Created by zm on 2019/1/5.
 */
class ResponseCommand<T, R> {
    private var execute: BindingFunction<R>? = null
    private var function: Function<T, R>? = null
    private var canExecute: BindingFunction<Boolean>? = null

    constructor(execute: BindingFunction<R>?) {
        this.execute = execute
    }

    constructor(function: Function<T, R>?) {
        this.function = function
    }

    constructor(execute: BindingFunction<R>?, canExecute: BindingFunction<Boolean>?) {
        this.execute = execute
        this.canExecute = canExecute
    }

    constructor(function: Function<T, R>?, canExecute: BindingFunction<Boolean>?) {
        this.function = function
        this.canExecute = canExecute
    }

    fun execute(): R? {
        if (canExecute()) {
            return execute?.call()
        }
        return null
    }

    fun excute(t: T): R?{
        if (canExecute()) {
            return function?.apply(t)
        }
        return null
    }

    /**
     * 是否需要执行
     * @return true则执行, 反之不执行
     */
    private fun canExecute(): Boolean {
        if (canExecute == null) {
            return true
        }
        return canExecute!!.call()
    }
}