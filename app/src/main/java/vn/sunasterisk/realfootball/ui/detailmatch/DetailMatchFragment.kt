package vn.sunasterisk.realfootball.ui.detailmatch

import android.os.Bundle
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.ViewModelBaseFragment
import vn.sunasterisk.realfootball.databinding.FragmentDetailMatchBinding

class DetailMatchFragment : ViewModelBaseFragment<DetailViewModel, FragmentDetailMatchBinding>() {

    override val viewModel: DetailViewModel by viewModel()

    override val contentViewId get() = R.layout.fragment_detail_match

    val idEvent by lazy {
        arguments?.let {
            DetailMatchFragmentArgs.fromBundle(it).idEvent
        }
    }
    val idHomeTeam by lazy {
        arguments?.let {
            DetailMatchFragmentArgs.fromBundle(it).idHome
        }
    }
    val idAwayTeam by lazy {
        arguments?.let {
            DetailMatchFragmentArgs.fromBundle(it).idAway
        }
    }

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
        viewDataBinding.viewModel = viewModel
        viewModel.initData(idEvent!!, idHomeTeam!!, idAwayTeam!!)

        viewModel.match.observe(viewLifecycleOwner, Observer {
            handlerError(it)
        })

        viewModel.homeTeam.observe(viewLifecycleOwner, Observer { team ->
            handlerError(team)
            team.result?.let { viewModel.updateHomeUrl(it) }
        })

        viewModel.awayTeam.observe(viewLifecycleOwner, Observer { team ->
            handlerError(team)
            team.result?.let { viewModel.updateAwayUrl(it) }
        })
    }
}
