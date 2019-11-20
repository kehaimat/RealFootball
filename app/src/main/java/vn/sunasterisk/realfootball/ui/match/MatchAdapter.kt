package vn.sunasterisk.realfootball.ui.match

import androidx.recyclerview.widget.DiffUtil
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.base.BaseRecyclerAdapter
import vn.sunasterisk.realfootball.data.model.Match
import vn.sunasterisk.realfootball.databinding.ItemMatchBinding

class MatchAdapter(
    val onItemClicked: (Match) -> Unit,
    val onItemNotifiClicked: (Match) -> Unit
) :
    BaseRecyclerAdapter<Match, ItemMatchBinding>(DiffUtilCallback()) {
    override fun getLayoutRes(viewType: Int) = R.layout.item_match

    override fun bindFirstTime(binding: ItemMatchBinding) {
        binding.apply {
            cardItemMatch.setOnClickListener {
                item?.let {
                    onItemClicked(it)
                }
            }
            imageNotification.setOnClickListener {
                item?.let {
                    onItemNotifiClicked(it)
                }
            }
        }
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match) =
            oldItem.idEvent == newItem.idEvent

        override fun areContentsTheSame(oldItem: Match, newItem: Match) = oldItem == newItem
    }
}
