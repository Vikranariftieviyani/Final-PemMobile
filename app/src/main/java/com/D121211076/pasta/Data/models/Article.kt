package com.D121211076.pasta.Data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Article(
    @SerialName("strMeal")
    val strMeal: String?,
    @SerialName("strMealThumb")
    val strMealThumb: String?,
    @SerialName("idMeal")
    val idMeal: String?
) : Parcelable
