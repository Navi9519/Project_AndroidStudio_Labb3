    package com.navi9519.labb_3_cocktail_app

    import UserViewModel
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.ui.Modifier
    import androidx.lifecycle.lifecycleScope
    import com.navi9519.labb_3_cocktail_app.model.database.MyDatabase
    import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import com.navi9519.labb_3_cocktail_app.navigation.MyApp
    import com.navi9519.labb_3_cocktail_app.view.theme.Labb_3_Cocktail_appTheme


    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val db = MyDatabase.getInstance(applicationContext)
            //db.openHelper.writableDatabase // Ensure the database is initialized
            val userRepository = UserRepository(db, lifecycleScope)

            val userViewModel = UserViewModel(userRepository)

            setContent {
                Labb_3_Cocktail_appTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        MyApp(userRepository, userViewModel)

                    }
                }
            }
        }
    }

