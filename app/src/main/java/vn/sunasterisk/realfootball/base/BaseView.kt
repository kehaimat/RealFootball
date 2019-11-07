package vn.sunasterisk.realfootball.base

import android.os.Bundle

interface BaseView {
    val contentViewId: Int
    fun initializeView(savedInstanceState: Bundle?)
    fun initializeComponents()
}
