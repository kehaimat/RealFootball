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
    private val navController by lazy {
        findNavController(R.id.navHost)
    }

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_news,
                R.id.navigation_match,
                R.id.navigation_team,
                R.id.navigation_highlight
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
