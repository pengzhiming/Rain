package com.zm.common.binding.command

/**
 * 执行的命令回调, 用于ViewModel与xml之间的数据绑定
 * <p>
 * Created by zm on 2019/1/5.
 */
class BindingCommand<T> {
    private var execute: BindingAction? = null
    private var consumer: BindingConsumer<T>? = null
    private var canExecute: BindingFunction<Boolean>? = null

    constructor(execute: BindingAction) {
        this.execute = execute
    }

    /**
     * @param execute 带泛型参数的命令绑定
     */
    constructor(execute: BindingConsumer<T>) {
        this.consumer = execute
    }

    /**
     * @param execute     触发命令
     * @param canExecute true则执行,反之不执行
     */
    constructor(execute: BindingAction, canExecute: BindingFunction<Boolean>) {
        this.execute = execute
        this.canExecute = canExecute
    }

    /**
     * @param execute     带泛型参数触发命令
     * @param canExecute true则执行,反之不执行
     */
    constructor(execute: BindingConsumer<T>, canExecute: BindingFunction<Boolean>) {
        this.consumer = execute
        this.canExecute = canExecute
    }

    /**
     *  执行BindingAction命令
     */
    fun execute() {
        if (canExecute()) {
            execute?.call()
        }
    }

    /**
     * 执行带泛型参数的命令
     * @param t 泛型参数
     */
    fun execute(t: T){
        if (canExecute()) {
            consumer?.call(t)
        }
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