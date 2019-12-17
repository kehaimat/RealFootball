package vn.sunasterisk.realfootball.ui.teamdetail

import android.os.Bundle
import org.koin.android.viewmodel.ext.android.sharedViewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.databinding.FragmentInfoBinding

class InformationFragment : BaseFragment<DetailTeamViewModel, FragmentInfoBinding>() {

    override val viewModel: DetailTeamViewModel by sharedViewModel(from = { parentFragment as BaseFragment<*, *> })
    override val contentViewId get() = R.layout.fragment_info
    override fun initializeView(savedInstanceState: Bundle?) {
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.viewModel = viewModel
    }

    override fun initializeComponents() {
    }

    companion object {
        fun newInstance() = InformationFragment()
    }
}
