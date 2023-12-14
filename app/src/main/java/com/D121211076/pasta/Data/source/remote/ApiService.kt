package com.D121211076.pasta.Data.source.remote

import com.D121211076.pasta.Data.response.GetPastaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    //https://www.themealdb.com/api/json/v1/1/filter.php?c=Pasta

    @GET("/json")
    suspend fun getPasta(
        @Query("c") c: String
    ): GetPastaResponse

}