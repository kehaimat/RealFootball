package vn.sunasterisk.realfootball.ui.playerdetail

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_detail_player.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.databinding.FragmentDetailPlayerBinding

class DetailPlayerFragment : BaseFragment<DetailPlayerViewModel, FragmentDetailPlayerBinding>() {
    override val viewModel: DetailPlayerViewModel by viewModel()
    override val contentViewId get() = R.layout.fragment_detail_player
    private val player by lazy {
        arguments?.let { DetailPlayerFragmentArgs.fromBundle(it).player }
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.viewModel = viewModel
        initTooBar(toolBar)
    }

    override fun initializeComponents() {
        viewModel.setPlayer(player)
    }
}
