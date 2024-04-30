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

    private val _drinksUiState = mutableStateOf<List<Drinks?>>(emptyList())
    var drinksUiState : State<List<Drinks?>> = _drinksUiState

    fun fetchRandomCocktails (num: Int) {
        viewModelScope.launch {
            try {
                val drinksList = mutableListOf<Drinks>()
                repeat(num) {
                    val drinks = DrinksRetrofit.fetchRandomCocktails(1)
                    drinksList.add(drinks)
                }
                _drinksUiState.value = drinksList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}