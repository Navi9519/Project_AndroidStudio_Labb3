package com.navi9519.labb_3_cocktail_app.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.navi9519.labb_3_cocktail_app.model.api.Drinks
import com.navi9519.labb_3_cocktail_app.model.api.DrinksRetrofit
import kotlinx.coroutines.launch
import java.lang.Exception

class DrinksViewModel: ViewModel() {

    private val _drinksUiState = mutableStateOf<Drinks?>( null)
    var drinksUiState : State<Drinks?> = _drinksUiState

    fun fetchDrinks () {
        viewModelScope.launch {
            try {
                _drinksUiState.value = DrinksRetrofit.fetchDrinks()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}