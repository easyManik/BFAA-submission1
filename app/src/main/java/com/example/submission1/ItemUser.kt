package com.example.submission1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemUser(
    var avatar : Int,
    var username: String,
    var name: String,
    var company : String,
    var repository: String,
    var location: String,
    var followers: String,
    var following: String
): Parcelable