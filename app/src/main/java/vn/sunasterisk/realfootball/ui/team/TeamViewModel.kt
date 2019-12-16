package vn.sunasterisk.realfootball.ui.team

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.data.repository.TeamRepository
import vn.sunasterisk.realfootball.utils.getLeaguesId

class TeamViewModel(
    application: Application,
    private val teamRepository: TeamRepository
) : AndroidViewModel(application) {
    private val application = application.applicationContext
    private val teamFilterId = MutableLiveData<String>()

    val teams: LiveData<BaseResponse<List<Team>>> =
        Transformations.switchMap(teamFilterId) {
            it?.let {
                teamRepository.getTeams(it)
            }
        }

    fun setTeamsFilterBy(position: Int) {
        teamFilterId.value = application.getLeaguesId(position)
    }
}
