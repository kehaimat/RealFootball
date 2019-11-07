package vn.sunasterisk.realfootball.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.exceptions.NetworkException
import vn.sunasterisk.realfootball.exceptions.ServiceException

abstract class BaseActivity : AppCompatActivity(), BaseView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewId)
        initializeView(savedInstanceState)
        initializeComponents()
    }

    override fun onBackPressed() {
        getCurrentFragment()?.let {
            if (it is BaseFragment<*> && it.onBackPressed()) {
                return
            }
        }
        super.onBackPressed()
    }

    private fun getCurrentFragment(): Fragment? {
        val currentNavHost = supportFragmentManager.findFragmentById(R.id.navHost)
        val currentFragmentClassName =
            (currentNavHost?.findNavController()?.currentDestination as FragmentNavigator.Destination).className
        return currentNavHost.childFragmentManager.fragments.filterNotNull().find {
            it.javaClass.name == currentFragmentClassName
        }
    }

    fun handleBusinessException(throwable: Throwable) {
        if (throwable is NetworkException) return
        if (throwable is ServiceException) return
    }
}
