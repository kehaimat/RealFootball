package vn.sunasterisk.realfootball

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import vn.sunasterisk.realfootball.base.BaseActivity

class MainActivity : BaseActivity() {
    override val contentViewId get() = R.layout.activity_main

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
    }
}
