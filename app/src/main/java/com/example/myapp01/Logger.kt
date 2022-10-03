package com.example.myapp01

import android.util.Log

/****
 * Project: My app01
 * From: com.example.myapp01
 * Created by José Zambrano Moya on 29/9/22 at 18:25
 * More info: zambranomoya74@gmail.com
 ****/
interface Logger {
    val tag: String
    get() = javaClass.simpleName

    fun logD(message: String) {
        Log.d(tag, message)
    }

    fun logE(message: String) {
        Log.e(tag, message)
    }
}