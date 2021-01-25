package com.devdossantos.compose

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddUserState(
    val name: String = "",
    val email: String = "",
    val role: String = ""
): Parcelable