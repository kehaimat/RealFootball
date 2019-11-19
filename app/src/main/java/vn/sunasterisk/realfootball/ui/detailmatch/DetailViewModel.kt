package vn.sunasterisk.realfootball.ui.detailmatch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.data.repository.TeamRepository

class DetailViewModel(
    application: Application,
    private val teamRepository: TeamRepository
) : AndroidViewModel(application) {

    private val _idHomeTeam = MutableLiveData<String>()
    private val _idAwayTeam = MutableLiveData<String>()
    val idHomeTeam get() = _idHomeTeam
    val idAwayTeam get() = _idAwayTeam

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

    fun update(team: Team){
        _urlHome.value=team.strTeamBadge
        _urlAway.value= team.strTeamBadge
    }

    fun initData(idHomeTeam: String, idAwayTeam: String) {
        this.idHomeTeam.value = idHomeTeam
        this.idAwayTeam.value = idAwayTeam
    }

    override fun onCleared() {
        super.onCleared()
        teamRepository.coroutines.onClear()
    }
}
