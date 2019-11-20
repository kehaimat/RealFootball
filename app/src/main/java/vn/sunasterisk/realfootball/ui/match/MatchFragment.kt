package vn.sunasterisk.realfootball.ui.match

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_match.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.ViewModelBaseFragment
import vn.sunasterisk.realfootball.constant.Constant
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.databinding.FragmentMatchBinding

class MatchFragment : ViewModelBaseFragment<MatchViewModel, FragmentMatchBinding>(),
    AdapterView.OnItemSelectedListener {
    override val viewModel: MatchViewModel by viewModel()
    override val contentViewId get() = R.layout.fragment_match
    private val adapter by lazy {
        MatchAdapter(
            onItemClicked = {
                findNavController().navigate(R.id.action_navigation_match_to_navigtion_detail)
            },
            onItemNotifiClicked = {
                createEventMatch(it)
            })
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
    }

    override fun initializeComponents() {
        spinnerLeagues.onItemSelectedListener = this
        setupList()
    }

    private fun setupList() {
        recycleMatch.adapter = adapter
        viewModel.nextMatches.observe(viewLifecycleOwner, Observer {
            handlerError(it)
            it.result?.let {
                adapter.submitList(it)
            }
        })
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.setMatchesFilterBy(position)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_next -> {
            viewModel.setTypeMatch(Constant.TYPE_NEXT_MATCH)
            true
        }

        R.id.menu_pre -> {
            viewModel.setTypeMatch(Constant.TYPE_PREV_MATCH)
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    fun createEventMatch(match: Match) {
        context?.startActivity(Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, "${match.strHomeTeam} vs ${match.strAwayTeam}")
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, match.getStartTime())
        })
    }
}
