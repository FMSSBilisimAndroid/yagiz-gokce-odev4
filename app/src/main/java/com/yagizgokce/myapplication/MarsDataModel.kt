package com.yagizgokce.myapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarsDataModel(
    var price: String,
    var id: String,
    var type: String,
    val img_src: String
): Parcelable
