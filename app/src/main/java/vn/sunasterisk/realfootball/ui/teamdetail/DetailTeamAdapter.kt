package vn.sunasterisk.realfootball.ui.teamdetail

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.utils.CurrentPosistion

class DetailTeamAdapter(private val context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var fragments = ArrayList<Fragment>()

    fun submitData(fragments: ArrayList<Fragment>) {
        this.fragments = fragments
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        CurrentPosistion.OVERVIEW -> context.getString(R.string.string_overview)
        CurrentPosistion.STADIUM -> context.getString(R.string.string_stadium)
        CurrentPosistion.INFORMATION -> context.getString(R.string.string_info)
        else -> super.getPageTitle(position)
    }
}
