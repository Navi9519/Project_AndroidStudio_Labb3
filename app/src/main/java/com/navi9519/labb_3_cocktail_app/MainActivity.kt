    package com.navi9519.labb_3_cocktail_app

    import UserExistViewModel
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.ui.Modifier
    import androidx.lifecycle.lifecycleScope
    import androidx.navigation.NavGraph
    import com.navi9519.labb_3_cocktail_app.model.database.MyDatabase
    import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import com.navi9519.labb_3_cocktail_app.navigation.MyApp
    import com.navi9519.labb_3_cocktail_app.view.composables.CocktailCard
    import com.navi9519.labb_3_cocktail_app.view.composables.TestApi
    import com.navi9519.labb_3_cocktail_app.view.composables.screens.UserCocktailScreen
    import com.navi9519.labb_3_cocktail_app.view.theme.Labb_3_Cocktail_appTheme
    import com.ramcosta.composedestinations.DestinationsNavHost

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val db = MyDatabase.getInstance(applicationContext)
            //db.openHelper.writableDatabase // Ensure the database is initialized
            val userRepository = UserRepository(db, lifecycleScope)

            val userExistViewModel = UserExistViewModel(userRepository)

            setContent {
                Labb_3_Cocktail_appTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        MyApp(userRepository, userExistViewModel)

                    }
                }
            }
        }
    }

