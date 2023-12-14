package com.D121211076.pasta.Data.repository

import com.D121211076.pasta.Data.response.GetPastaResponse
import com.D121211076.pasta.Data.source.remote.ApiService

class PastaRepository(private val apiService: ApiService) {

    suspend fun getPasta(c: String): GetPastaResponse {
        return apiService.getPasta(c)
    }

}