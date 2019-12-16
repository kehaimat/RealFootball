package vn.sunasterisk.realfootball.ui.team

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_teams.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.BottomNavigationFragmentDirections
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.databinding.FragmentTeamsBinding

class TeamFragment : BaseFragment<TeamViewModel, FragmentTeamsBinding>(),
    AdapterView.OnItemSelectedListener {

    override val viewModel: TeamViewModel by viewModel()
    override val contentViewId get() = R.layout.fragment_teams
    private val mainNavController by lazy {
        Navigation.findNavController(requireActivity(), R.id.navMain)
    }
    private val adapter by lazy { TeamAdapter { openDetailTeam(it) } }

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
        spinnerLeague.onItemSelectedListener = this
        setupList()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.setTeamsFilterBy(position)
    }

    private fun setupList() {
        recyclerTeams.adapter = adapter
        viewModel.teams.observe(viewLifecycleOwner, Observer {
            handlerError(it)
            it.result?.let {
                adapter.submitList(it)
            }
        })
    }

    private fun openDetailTeam(team: Team) {
        mainNavController.navigate(
            BottomNavigationFragmentDirections.actionNavigationMainToNavigationTeamDetail(team)
        )
    }
}
