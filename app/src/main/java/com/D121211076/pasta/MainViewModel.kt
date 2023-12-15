package com.D121211076.pasta



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211076.pasta.Data.models.Article
import com.D121211076.pasta.Data.repository.PastaRepository

import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val foods: List<Article>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val pastaRepo: PastaRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getFoods() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = pastaRepo.getPasta(
                "Pasta"
            )
            mainUiState = MainUiState.Success(result.meals.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getFoods()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val foodsRepository = application.container.pastaRepository
                MainViewModel(foodsRepository)
            }
        }
    }
}