package com.lfy.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lfy.mylibrary.ToastUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastUtils.init(applicationContext)
        window.decorView.postDelayed({
            ToastUtils.toast("成功")
        },2000)

    }
}