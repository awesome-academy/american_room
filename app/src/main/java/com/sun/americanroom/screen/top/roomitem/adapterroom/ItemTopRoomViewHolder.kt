package com.sun.americanroom.screen.top.room.adapterroom

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.utils.Constant
import com.sun.americanroom.utils.loadImage
import kotlinx.android.synthetic.main.item_room_horizontal.view.*

class ItemTopRoomViewHolder(
    itemTopRoomView: View,
    private val onItemClicked: (TopRoom) -> Unit
) : RecyclerView.ViewHolder(itemTopRoomView) {

    fun bindViewData(topRoom: TopRoom) {
        itemView.apply {
            if (topRoom.rating.toString().equals(Constant.NULL)) {
                cardViewRating.isVisible = false
            } else {
                textViewRating.text = topRoom.rating.toString()
            }
            textViewRoomName.text = topRoom.name.toString()
            topRoom.image?.let { imageViewTopRoom.loadImage(it) }
            setOnClickListener {
                onItemClicked(topRoom)
            }
        }
    }
}
