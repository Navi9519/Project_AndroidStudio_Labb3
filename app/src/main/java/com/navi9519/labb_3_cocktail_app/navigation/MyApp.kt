package com.navi9519.labb_3_cocktail_app.navigation

import com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel.UserViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
import com.navi9519.labb_3_cocktail_app.view.composables.FindCocktailList
import com.navi9519.labb_3_cocktail_app.view.composables.UserCocktailList
import com.navi9519.labb_3_cocktail_app.view.composables.screens.AboutScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.CocktailCardScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.FindCocktailScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.HomeScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.LoginScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.SignUpScreen
import com.navi9519.labb_3_cocktail_app.view.composables.screens.UserCocktailScreen
import com.navi9519.labb_3_cocktail_app.viewmodels.DrinksViewModel


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
        composable("FindCocktailScreen") {
            FindCocktailScreen(
                navController,
                userViewModel,
                userRepository
            )

        }

        composable("UserCocktailScreen") {
            UserCocktailScreen(
                navController,
                userViewModel,
                userRepository
            )

        }

        composable("FindCocktailList") {
            FindCocktailList(
                navController,
                DrinksViewModel(),
                "Add to favorites",
                userViewModel,
                userRepository
            )
        }

        composable("UserCocktailList") {
            UserCocktailList(
                navController,
                "Remove",
                userViewModel,
                userRepository
            )
        }


        composable(
            "CocktailCardScreen/{cocktailName}",
            arguments = listOf(navArgument("cocktailName") { type = NavType.StringType })
        ) { backStackEntry ->
            val cocktailName = backStackEntry.arguments?.getString("cocktailName")
            CocktailCardScreen(
                navController,
                userViewModel,
                userRepository,
                cocktailName = cocktailName
            )
        }



        /*
        composable(
            "CocktailCardScreen/{cocktailImg}/{cocktailName}/{cocktailCategory}/{cocktailInstructions}",
            arguments = listOf(
                navArgument("encodedCocktailImg") { type = NavType.StringType },
                navArgument("cocktailName") { type = NavType.StringType },
                navArgument("cocktailCategory") { type = NavType.StringType },
                navArgument("cocktailInstructions") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val cocktailImg = backStackEntry.arguments?.getString("cocktailImg")
            val cocktailName = backStackEntry.arguments?.getString("cocktailName")
            val cocktailCategory = backStackEntry.arguments?.getString("cocktailCategory")
            val cocktailInstructions = backStackEntry.arguments?.getString("cocktailInstructions")
            println(cocktailImg)
            CocktailCardScreen(
                navController,
                cocktailImg = cocktailImg,
                cocktailName = cocktailName,
                cocktailCategory = cocktailCategory,
                cocktailInstructions = cocktailInstructions
                // Pass any other necessary parameters
            )
        }



 */


    }

}