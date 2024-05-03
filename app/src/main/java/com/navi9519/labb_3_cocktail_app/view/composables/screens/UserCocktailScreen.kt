package com.navi9519.labb_3_cocktail_app.view.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.view.composables.Btn
import com.navi9519.labb_3_cocktail_app.view.composables.CocktailList
import com.navi9519.labb_3_cocktail_app.view.theme.GoldColor
import com.navi9519.labb_3_cocktail_app.viewmodels.DrinksViewModel


@Composable
//@Preview(showBackground = true)
fun UserCocktailScreen(
    navController: NavController,
    username: String?
) {

    val viewModel: DrinksViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.usercocktail_background),
            contentDescription = "Login-background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()

        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
            ,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Hello $username",
                modifier = Modifier
                    .padding(top = 45.dp, bottom = 20.dp),
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    color = GoldColor,
                    textAlign = TextAlign.Center,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(-16f, 16f),
                        blurRadius = 8f
                    )
                )

            )

            Text(
                text = "Your personal cocktail list:",
                modifier = Modifier
                    .padding(top = 45.dp, bottom = 20.dp),
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    color = GoldColor,
                    textAlign = TextAlign.Center,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(-16f, 16f),
                        blurRadius = 8f
                    )
                )

            )
            CocktailList(viewModel, "Remove")

            Btn(text = "Find cocktails") {
                navController.navigate("FindCocktailScreen")

            }

            Btn(text = "Logout/Home") {
                navController.navigate("HomeScreen")
            }



        }

    }


}