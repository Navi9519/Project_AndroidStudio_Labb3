package com.navi9519.labb_3_cocktail_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.navi9519.labb_3_cocktail_app.ui.composables.TestApi
import com.navi9519.labb_3_cocktail_app.ui.composables.screens.LoginScreen
import com.navi9519.labb_3_cocktail_app.ui.theme.Labb_3_Cocktail_appTheme

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
                    // TestApi()
                    LoginScreen()
                }
            }
        }
    }
}

