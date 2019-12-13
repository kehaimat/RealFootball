package vn.sunasterisk.realfootball.ui.team

import androidx.recyclerview.widget.DiffUtil
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseRecyclerAdapter
import vn.sunasterisk.realfootball.data.model.Team
import vn.sunasterisk.realfootball.databinding.ItemTeamBinding

class TeamAdapter(
    val onItemClicked: (Team) -> Unit
) :
    BaseRecyclerAdapter<Team, ItemTeamBinding>(DiffUtilCallback()) {

    override fun getLayoutRes(viewType: Int) = R.layout.item_team

    override fun bindFirstTime(binding: ItemTeamBinding) {

        binding.apply {
            itemLayout.setOnClickListener {
                item?.let {
                    onItemClicked(it)
                }
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team) =
            oldItem.idTeam == newItem.idTeam

        override fun areContentsTheSame(oldItem: Team, newItem: Team) = oldItem == newItem
    }
}
