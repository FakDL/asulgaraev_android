package com.example.mobile_course

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Song(
    var author: String = "",
    var name: String = "",
    var photoId: Int = 0,
    var songId: Int = 0
) : Parcelable {

    companion object CREATOR : Parcelable.Creator<Song> {
        override fun createFromParcel(parcel: Parcel): Song {
            return Song(parcel)
        }

        override fun newArray(size: Int): Array<Song> {
            return Array(size) { Song() }
        }
    }

    private constructor(inParcel: Parcel) : this() {
        readFromParcel(inParcel)
    }

    private fun readFromParcel(inParcel: Parcel) {
        author = inParcel.readString() ?: ""
        name = inParcel.readString() ?: ""
        songId = inParcel.readInt() ?: 0
        photoId = inParcel.readInt() ?: 0
    }

    override fun writeToParcel(outParcel: Parcel, flags: Int) {
        outParcel.writeString(author)
        outParcel.writeString(name)
        outParcel.writeInt(songId)
        outParcel.writeInt(photoId)
    }

    override fun describeContents(): Int = 0
}