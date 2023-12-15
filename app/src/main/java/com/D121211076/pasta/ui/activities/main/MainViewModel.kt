package com.D121211076.pasta.ui.activities.main

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
import com.D121211076.pasta.Data.models.Article
import com.D121211076.pasta.MyApplication
import com.D121211076.pasta.Data.repository.PastaRepository
import com.D121211076.pasta.Data.response.GetPastaResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MainUiState {
    data class Success(val pasta: Article?) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val pastaRepository: PastaRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    private fun getPasta() = viewModelScope.launch {
            mainUiState = MainUiState.Loading
            try {
                val result = pastaRepository.getPasta(
                    c = "Pasta"
                )
                mainUiState = MainUiState.Success(result.meals)
                Log.d("MainViewModel", "getPasta success : ${result.meals}")
            } catch (e: IOException) {
                MainUiState.Error
            } catch (e: HttpException) {
                MainUiState.Error
            }
        }


    init {
        getPasta()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val pastaRepository = application.container.pastaRepository
                MainViewModel(pastaRepository)
            }
        }
    }

}