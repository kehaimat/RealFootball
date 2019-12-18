package vn.sunasterisk.realfootball.ui.playerdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import vn.sunasterisk.realfootball.R

class DetailPlayerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_detail_player, container, false)
}
