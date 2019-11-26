package vn.sunasterisk.realfootball.ui.match

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.constant.Constant
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.data.repository.MatchRepository
import vn.sunasterisk.realfootball.utils.AbsentLiveData
import vn.sunasterisk.realfootball.utils.getLeaguesId

class MatchViewModel(
    application: Application,
    private val matchRepository: MatchRepository
) : AndroidViewModel(application) {
    private val matchFilterId = MutableLiveData<String>()
    private val _typeMatch = MutableLiveData<String>(Constant.TYPE_NEXT_MATCH)
    private val typeMatch get() = _typeMatch.value
    private val application = application.applicationContext // application Context to avoid leaks

    val nextMatches: LiveData<BaseResponse<List<Match>>> =
        Transformations.switchMap(matchFilterId) { leagueId ->
            if (leagueId.isNullOrBlank()) {
                AbsentLiveData.create()
            } else {
                matchRepository.getMatch(leagueId, typeMatch!!)
            }
        }

    fun setMatchesFilterBy(position: Int) {
        matchFilterId.value = application.getLeaguesId(position)
    }
    
    fun setTypeMatch(type: String) {
        _typeMatch.value = type
        matchFilterId.value = matchFilterId.value
    }

}
