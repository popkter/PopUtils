package com.popkter.poputils.sharepreference

import android.content.Context
import android.content.SharedPreferences

class SharePreferenceHelper(mContext: Context, name: String) {
    private val mSharePreferences: SharedPreferences
    private val mEditor: SharedPreferences.Editor

    private fun putInt(key: String, value: Int) {
        mEditor.putInt(key, value).apply()
    }

    private fun getInt(key: String, defaultValue: Int): Int {
        return mSharePreferences.getInt(key, defaultValue)
    }

    private fun putLong(key: String, value: Long) {
        mEditor.putLong(key, value).apply()
    }

    private fun getLong(key: String, defaultValue: Long): Long {
        return mSharePreferences.getLong(key, defaultValue)
    }

    private fun putFloat(key: String, value: Float) {
        mEditor.putFloat(key, value).apply()
    }

    private fun getFloat(key: String, defaultValue: Float): Float {
        return mSharePreferences.getFloat(key, defaultValue)
    }

    private fun putString(key: String, value: String) {
        mEditor.putString(key, value).apply()
    }

    private fun getString(key: String, defaultValue: String): String {
        var string = mSharePreferences.getString(key, defaultValue)
        if (string == null) {
            string = ""
        }
        return string
    }

    private fun putBoolean(key: String, value: Boolean) {
        mEditor.putBoolean(key, value).apply()
    }

    private fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return mSharePreferences.getBoolean(key, defaultValue)
    }

    fun put(key: String, value: Any) {
        when (value) {
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is String -> putString(key, value)
            is Boolean -> putBoolean(key, value)
            else -> return
        }
    }

    fun <T> get(key: String, defaultObject: T): T {
        when (defaultObject) {
            is String -> {
                return getString(key, defaultObject as String) as T
            }
            is Int -> {
                return Integer.valueOf(getInt(key, defaultObject as Int)) as T
            }
            is Boolean -> {
                return java.lang.Boolean.valueOf(getBoolean(key, defaultObject as Boolean)) as T
            }
            is Long -> {
                return java.lang.Long.valueOf(getLong(key, defaultObject as Long)) as T
            }
            is Float -> {
                return java.lang.Float.valueOf(getFloat(key, defaultObject as Float)) as T
            }
            else -> return defaultObject
        }
    }

    init {
        mSharePreferences = mContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        mEditor = mSharePreferences.edit()
    }
}