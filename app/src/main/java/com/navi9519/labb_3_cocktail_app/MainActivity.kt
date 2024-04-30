package com.navi9519.labb_3_cocktail_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import com.navi9519.labb_3_cocktail_app.view.composables.TestApi
import com.navi9519.labb_3_cocktail_app.view.composables.screens.NavGraphs
import com.navi9519.labb_3_cocktail_app.view.composables.screens.UserCocktailScreen
import com.navi9519.labb_3_cocktail_app.view.theme.Labb_3_Cocktail_appTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labb_3_Cocktail_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                   DestinationsNavHost(navGraph = NavGraphs.root)
                    
                     //Test()
                     //TestApi()
                    //HomeScreen()
                    //AboutScreen()
                    // LoginScreen()
                    //SignUpScreen()
                //FindCocktailScreen()
                //UserCocktailScreen()
                   /* CocktailCard(
                        onDismissRequest = { /*TODO*/ },
                        onConfirmation = { /*TODO*/ },
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        imageDescription = "Cocktail"
                    )  */
                }
            }
        }
    }
}

