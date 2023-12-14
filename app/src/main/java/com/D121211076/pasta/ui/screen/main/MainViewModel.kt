package com.D121211076.pasta.ui.screen.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211076.pasta.MyApplication
import com.D121211076.pasta.Data.repository.PastaRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val pasta: Pasta) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val PastaRepository: PastaRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getPasta() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = PastaRepository.getPasta(
                q = "pemilu",
                from = "2023-10-15",
                sortBy = "publishedAt"
            )
            Log.d("MainViewModel", "getPasta: ${result.articles?.size}")
            mainUiState = MainUiState.Success(result.articles.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getPasta error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getPasta()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val PastaRepository = application.container.PastaRepository
                MainViewModel(PastaRepository)
            }
        }
    }

}