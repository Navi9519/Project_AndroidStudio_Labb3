package com.navi9519.labb_3_cocktail_app.navigation

import com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel.UserViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
import com.navi9519.labb_3_cocktail_app.view.composables.screens.AboutScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.FindCocktailScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.HomeScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.LoginScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.SignUpScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.UserCocktailScreen


@Composable
fun MyApp(
    userRepository: UserRepository,
    userViewModel: UserViewModel,
) {
    val navController = rememberNavController()

    // TODO - NavGraph + Multiple Destinations

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") { HomeScreen(navController) }
        composable("AboutScreen") { AboutScreen(navController) }
        composable("LoginScreen") { LoginScreen(navController, userViewModel) }
        composable("SignUpScreen") { SignUpScreen(navController, userRepository, userViewModel) }
        composable("FindCocktailScreen") { FindCocktailScreen(
            navController,
            userViewModel,
            userRepository
        )

        }

        composable("UserCocktailScreen") { UserCocktailScreen(
            navController,
            userViewModel,
            userRepository
        )

        }


    }

}