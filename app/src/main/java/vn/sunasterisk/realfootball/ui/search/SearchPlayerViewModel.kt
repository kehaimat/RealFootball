package vn.sunasterisk.realfootball.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Player
import vn.sunasterisk.realfootball.data.repository.PlayerRepository

class SearchPlayerViewModel(
    application: Application,
    playerRepository: PlayerRepository
) : AndroidViewModel(application) {
    private val query = MutableLiveData<String>()
    val result: LiveData<BaseResponse<List<Player>>> = Transformations.switchMap(query) { q ->
        playerRepository.searchTeam(q)
    }

    fun submitQuery(query: String?) {
        if (!query.isNullOrEmpty() && (this.query.value != query)) {
            this.query.value = query
        }
    }
}
