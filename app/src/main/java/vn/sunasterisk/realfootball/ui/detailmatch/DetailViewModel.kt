package vn.sunasterisk.realfootball.ui.detailmatch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.data.repository.MatchRepository
import vn.sunasterisk.realfootball.data.repository.TeamRepository

class DetailViewModel(
    application: Application,
    private val teamRepository: TeamRepository,
    private val matchRepository: MatchRepository
) : AndroidViewModel(application) {

    private val _idHomeTeam = MutableLiveData<String>()
    private val _idAwayTeam = MutableLiveData<String>()
    private val _idEvent = MutableLiveData<String>()

    private val _urlHome = MutableLiveData<String>()
    private val _urlAway = MutableLiveData<String>()

    val urlHome get() = _urlHome
    val urlAway get() = _urlAway

    val homeTeam: LiveData<BaseResponse<Team>> = Transformations.switchMap(_idHomeTeam) {
        it?.let {
            teamRepository.getTeam(it)
        }
    }
    val awayTeam: LiveData<BaseResponse<Team>> = Transformations.switchMap(_idAwayTeam) {
        it?.let {
            teamRepository.getTeam(it)
        }
    }

    val match: LiveData<BaseResponse<Match>> = Transformations.switchMap(_idEvent) {
        it?.let {
            matchRepository.getEventDetail(it)
        }
    }

    fun updateHomeUrl(team: Team) {
        _urlHome.value = team.strTeamBadge
    }

    fun updateAwayUrl(team: Team) {
        _urlAway.value = team.strTeamBadge
    }

    fun initData(idEvent: String, idHomeTeam: String, idAwayTeam: String) {
        _idHomeTeam.value = idHomeTeam
        _idAwayTeam.value = idAwayTeam
        _idEvent.value = idEvent
    }
}
