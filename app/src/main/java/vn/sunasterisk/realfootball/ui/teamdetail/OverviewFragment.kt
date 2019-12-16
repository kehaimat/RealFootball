package vn.sunasterisk.realfootball.ui.teamdetail

import android.os.Bundle
import org.koin.android.viewmodel.ext.android.sharedViewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.databinding.FragmentOverviewTeamBinding

class OverviewFragment : BaseFragment<DetailTeamViewModel, FragmentOverviewTeamBinding>() {
    override val viewModel: DetailTeamViewModel by sharedViewModel(from = { parentFragment as BaseFragment<*, *> })
    override val contentViewId get() = R.layout.fragment_overview_team
    override fun initializeView(savedInstanceState: Bundle?) {
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.viewModel = viewModel
    }

    override fun initializeComponents() {
    }

    companion object {
        fun newInstance() = OverviewFragment()
    }
}
