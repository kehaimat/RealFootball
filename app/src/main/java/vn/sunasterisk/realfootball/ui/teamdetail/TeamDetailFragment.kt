package vn.sunasterisk.realfootball.ui.teamdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.databinding.FragmentDetailTeamBinding

class TeamDetailFragment : BaseFragment<DetailTeamViewModel, FragmentDetailTeamBinding>() {
    override val viewModel: DetailTeamViewModel by viewModel()
    override val contentViewId: Int get() = R.layout.fragment_detail_team
    val team by lazy {
        arguments?.let { TeamDetailFragmentArgs.fromBundle(it).team }
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.viewModel = viewModel
    }

    override fun initializeComponents() {
        val adapter = DetailTeamAdapter(requireContext(), childFragmentManager)
        viewDataBinding.viewPagerTeamDetail.adapter = adapter
        viewDataBinding.tabTeam.setupWithViewPager(viewDataBinding.viewPagerTeamDetail)
        initAdapter(adapter)
        viewModel.setTeam(team)
    }

    private fun initAdapter(adapter: DetailTeamAdapter) {
        val fragmens = ArrayList<Fragment>()
        fragmens.apply {
            add(OverviewFragment.newInstance())
            add(StadiumFragment.newInstance())
            add(InformationFragment.newInstance())
        }
        adapter.submitData(fragmens)
    }
}
