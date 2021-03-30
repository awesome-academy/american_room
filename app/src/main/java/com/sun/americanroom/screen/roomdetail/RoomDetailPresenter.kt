package com.sun.americanroom.screen.roomdetail

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.sun.americanroom.data.model.Room
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener
import com.sun.americanroom.data.source.repository.RoomRepository
import com.sun.americanroom.utils.Constant
import java.lang.Exception
import java.util.*

class RoomDetailPresenter(
    private val repository: RoomRepository
) : RoomDetailContract.Presenter {

    private var view: RoomDetailContract.View? = null

    override fun getRoomDetail(state: String, id: Int) {
        repository.getRoomDetail(object : OnFetchDataJsonListener<Room> {
            override fun onSuccess(data: Room) {
                view?.getRoomDetailOnSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        }, state, id)
    }

    override fun getListRelatedRoom(state: String, city: String) {
        repository.getTopRoom(object : OnFetchDataJsonListener<MutableList<TopRoom>> {
            override fun onSuccess(data: MutableList<TopRoom>) {
                view?.getListRelatedRoomOnSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        }, state, city)
    }

    override fun displayLocationInMap(
        context: Context,
        latitude: Float,
        longitude: Float
    ) {
        val uri = String.format(
            Locale.ENGLISH,
            Constant.FORMAT_LOCATION,
            latitude,
            longitude
        )
        Intent(Intent.ACTION_VIEW, Uri.parse(uri)).run {
            context.startActivity(this)
        }
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: RoomDetailContract.View?) {
        this.view = view
    }
}
