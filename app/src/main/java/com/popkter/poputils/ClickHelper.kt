package com.popkter.poputils

import android.view.View
import com.popkter.poputils.PopClickConstants.delayMills

/**
 * 单击防抖，默认初始的延迟500ms
 * [onClick] 点击事件
 */
inline fun View.setOnSingleClickListener(crossinline onClick: () -> Unit) {
    this.setOnClickListener {
        isClickable = false
        onClick()
        postDelayed({ isClickable = true }, delayMills)
    }
}

/**
 * 长按防抖，默认初始的延迟500ms
 * [onLongClick] 长按事件
 */
inline fun View.setOnLongSingleClickListener(crossinline onLongClick: () -> Boolean) {
    this.setOnLongClickListener {
        isClickable = false
        val result = onLongClick()
        postDelayed({ isClickable = true }, delayMills)
        result
    }
}

/**
 * 单击防抖，自定义延迟时间
 * [onClick] 点击事件
 */
inline fun View.setOnSingleClickListener(delayMillis: Long, crossinline onClick: () -> Unit) {
    this.setOnClickListener {
        isClickable = false
        onClick()
        postDelayed({ isClickable = true }, delayMillis)
    }
}

/**
 * 长按防抖，自定义延迟时间
 * [onLongClick] 长按事件
 */
inline fun View.setOnLongSingleClickListener(delayMillis: Long, crossinline onLongClick: () -> Boolean) {
    this.setOnLongClickListener {
        isClickable = false
        val result = onLongClick()
        postDelayed({ isClickable = true }, delayMillis)
        result
    }
}
