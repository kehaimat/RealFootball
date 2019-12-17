package vn.sunasterisk.realfootball.ui.teamdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vn.sunasterisk.realfootball.data.model.Team

class DetailTeamViewModel(application: Application) : AndroidViewModel(application) {
    private val _itemTeam = MutableLiveData<Team>()
    val itemTeam: LiveData<Team> = _itemTeam
    fun setTeam(team: Team?) {
        _itemTeam.value = team
    }
}
