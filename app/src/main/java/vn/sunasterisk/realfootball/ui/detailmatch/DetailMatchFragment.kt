package vn.sunasterisk.realfootball.ui.detailmatch

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail_match.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.base.ViewModelBaseFragment
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.databinding.FragmentDetailMatchBinding
import vn.sunasterisk.realfootball.extension.formatDate
import vn.sunasterisk.realfootball.extension.getHour

class DetailMatchFragment : ViewModelBaseFragment<DetailViewModel, FragmentDetailMatchBinding>() {

    override val viewModel: DetailViewModel by viewModel()

    override val contentViewId get() = R.layout.fragment_detail_match

    val match by lazy {
        arguments?.let {
            DetailMatchFragmentArgs.fromBundle(it).match
        }
    }
    val idHomeTeam by lazy {
        match?.idHomeTeam
    }
    val idAwayTeam by lazy {
        match?.idAwayTeam
    }

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun initializeComponents() {
        match?.let { initData(it) }
        viewModel.initData(idHomeTeam!!, idAwayTeam!!)
        Toast.makeText(context,"$idHomeTeam vs $idAwayTeam",Toast.LENGTH_SHORT).show()
        viewModel.homeTeam.observe(this, Observer { res ->
            handlerError(res)
//            viewModel.urlHome.value= res.result?.strTeamBadge
            res.result?.let { viewModel.update(it) }
//            Toast.makeText(context,"Home ${viewModel.urlHome.value.toString()}",Toast.LENGTH_SHORT).show()
            setupHomeTeam(res)
        })
        viewModel.awayTeam.observe(this, Observer { res ->
            handlerError(res)
//            viewModel.urlAway.value= res.result?.strTeamBadge
            res.result?.let { viewModel.update(it) }
//            Toast.makeText(context,"Away ${viewModel.urlAway.value.toString()}",Toast.LENGTH_SHORT).show()
//            setupAwayTeam(res)
        })
    }

    private fun setupAwayTeam(resource: BaseResponse<Team>?) {
        resource?.result?.strTeamBadge?.let {
            Glide.with(context!!).load(it).into(imageAway)
        }
    }

    private fun setupHomeTeam(resource: BaseResponse<Team>?) {
        resource?.result?.strTeamBadge?.let {
            Glide.with(context!!).load(it).into(imageHome)
        }
    }

    private fun initData(match: Match) {
        with(match) {
            textDate.text = dateEvent?.formatDate()
            textHour.text = strTime?.getHour()
            textHome.text = strHomeTeam
            textScoreHome.text = intHomeScore
            textAway.text = strAwayTeam
            textScoreAway.text = intAwayScore
            textGoalHome.text = format(strHomeGoalDetails)
            textGoalAway.text = format(strAwayGoalDetails)
            textShotsHome.text = intHomeShots ?: "-"
            textShotsAway.text = intAwayShots ?: "-"
            textYellowHome.text = strHomeYellowCards
            textYellowAway.text = strAwayYellowCards
            textRedHome.text = strHomeRedCards
            textRedAway.text = strAwayRedCards
            textGKHome.text = format(strHomeLineupGoalkeeper)
            textGKAway.text = format(strAwayLineupGoalkeeper)
            textDefenseHome.text = format(strHomeLineupDefense)
            textDefenseAway.text = format(strAwayLineupDefense)
            textMidfieldHome.text = format(strHomeLineupMidfield)
            textMidfieldAway.text = format(strAwayLineupMidfield)
            textForwardHome.text = format(strHomeLineupForward)
            textForwardAway.text = format(strAwayLineupForward)
            textSubtitutesHome.text = format(strHomeLineupSubstitutes)
            textSubtitutesAway.text = format(strAwayLineupSubstitutes)
        }
    }
}
