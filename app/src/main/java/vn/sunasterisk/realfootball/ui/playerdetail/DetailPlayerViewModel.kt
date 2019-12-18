package vn.sunasterisk.realfootball.ui.playerdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vn.sunasterisk.realfootball.data.model.Player

class DetailPlayerViewModel(application: Application) : AndroidViewModel(application) {
    private val _itemPlayer = MutableLiveData<Player>()
    val itemPlayer: LiveData<Player> = _itemPlayer
    fun setPlayer(player: Player?) {
        _itemPlayer.value = player
    }
}
