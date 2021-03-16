package com.sun.americanroom.data.source

import com.sun.americanroom.data.model.City
import com.sun.americanroom.data.model.NewRoom
import com.sun.americanroom.data.model.TopRoom
import com.sun.americanroom.data.source.remote.OnFetchDataJsonListener

interface RoomDataSource {

    interface Local

    interface Remote {
        fun getCity(
            listener: OnFetchDataJsonListener<MutableList<City>>,
            state: String,
            numberOfCity: Int
        )

        fun getTopRoom(
            listener: OnFetchDataJsonListener<MutableList<TopRoom>>,
            state: String,
            city: String
        )

        fun getNewRoom(
            listener: OnFetchDataJsonListener<MutableList<NewRoom>>,
            state: String,
            city: String
        )
    }
}
