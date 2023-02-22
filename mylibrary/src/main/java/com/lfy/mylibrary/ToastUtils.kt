package com.lfy.mylibrary

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

/**
 * @Author admin
 * @Date 2022/8/24-9:52
 * @describe:toast单例
 */
@SuppressLint("StaticFieldLeak")
object ToastUtils {

    private var context:Context?=null
    fun init(mContext: Context){
        context=mContext
    }

    private var oldMsg: String = ""
    private var clickTime: Long = 0//点击的时间
    private val toast by lazy (LazyThreadSafetyMode.SYNCHRONIZED) {
        Toast.makeText(
            context?.applicationContext,
            oldMsg,
            Toast.LENGTH_SHORT
        )
    }

    fun toast(msg: Any?) {
        val nowTime = System.currentTimeMillis()
        if (oldMsg == msg.toString()) {
            if (nowTime - clickTime > 1000) {
                toast.setText(msg.toString())
                toast.show()
                clickTime = nowTime
            }
        } else {
            toast.setText(msg.toString())
            toast.show()
            clickTime = nowTime
            oldMsg = msg.toString()
        }
    }

}