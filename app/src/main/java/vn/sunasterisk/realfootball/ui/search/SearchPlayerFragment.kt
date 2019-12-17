package vn.sunasterisk.realfootball.ui.search

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_search_player.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sunasterisk.realfootball.BottomNavigationFragment
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseFragment
import vn.sunasterisk.realfootball.base.BaseResponse
import vn.sunasterisk.realfootball.data.model.Player
import vn.sunasterisk.realfootball.databinding.FragmentSearchPlayerBinding
import vn.sunasterisk.realfootball.utils.SpaceItemDecoration

class SearchPlayerFragment : BaseFragment<SearchPlayerViewModel, FragmentSearchPlayerBinding>() {
    private val searchAdapter by lazy { PlayerAdapter({}) }
    override val viewModel: SearchPlayerViewModel by viewModel()
    override val contentViewId = R.layout.fragment_search_player
    override fun initializeView(savedInstanceState: Bundle?) {
        viewDataBinding.lifecycleOwner = this
    }

    override fun initializeComponents() {
        recyclerSearchPlayer.apply {
            addItemDecoration(SpaceItemDecoration(context.resources.getDimensionPixelSize(R.dimen.dp_4)))
            setHasFixedSize(true)
            adapter = searchAdapter
        }
        searchPlayer.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.submitQuery(query)
                return true
            }

            override fun onQueryTextChange(newText: String?) = true
        })
        viewModel.result.observe(viewLifecycleOwner, Observer(::updateData))
    }

    private fun updateData(data: BaseResponse<List<Player>>?) {
        if (data == null || recyclerSearchPlayer == null) return
        searchAdapter.submitList(data.result)
    }
}
