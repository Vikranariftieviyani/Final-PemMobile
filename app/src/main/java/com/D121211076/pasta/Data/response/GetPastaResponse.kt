package com.D121211076.pasta.Data.response

import com.D121211076.pasta.Data.models.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetPastaResponse(
    @SerialName("meals")
    val meals: List<Article>?
)