package vn.sunasterisk.realfootball.ui.search

import androidx.recyclerview.widget.DiffUtil
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseRecyclerAdapter
import vn.sunasterisk.realfootball.data.model.Player
import vn.sunasterisk.realfootball.databinding.ItemPlayerBinding

class PlayerAdapter(
    val onItemClicked: (Player) -> Unit
) : BaseRecyclerAdapter<Player, ItemPlayerBinding>(DiffUtilCallback()) {
    override fun getLayoutRes(viewType: Int) = R.layout.item_player

    override fun bindFirstTime(binding: ItemPlayerBinding) {
        binding.apply {
            cardView.setOnClickListener {
                item?.let {
                    onItemClicked(it)
                }
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player) =
            oldItem.idPlayer == newItem.idPlayer

        override fun areContentsTheSame(oldItem: Player, newItem: Player) = oldItem == newItem
    }
}
