package com.D121211076.pasta.Data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Article(
    @SerialName("strMeal")
    val author: String?,
    @SerialName("strMealThumb")
    val content: String?,
    @SerialName("idMeal")
    val description: String?
) : Parcelable