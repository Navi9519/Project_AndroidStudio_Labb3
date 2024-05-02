package com.navi9519.labb_3_cocktail_app.view.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun FindCocktailScreen(
    navController: NavController
) {

    val viewModel: DrinksViewModel = viewModel()

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(R.drawable.findcocktail_background),
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
            SearchBar(
                modifier = Modifier
                    .height(95.dp)
                    .padding(top = 30.dp)
                    .width(300.dp),
                query = "",
                onQueryChange = {},
                onSearch = {},
                placeholder = {
                    Text(
                        text = "Find Cocktails",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            color = GoldColor
                        )

                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        tint = GoldColor,
                        contentDescription = null
                    )
                },
                trailingIcon = {},
                content = {},
                active = true,
                onActiveChange = {},
                tonalElevation = 0.dp
            )
Text(
    text = "10 random cocktails, reload for new ones:",
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
            CocktailList(viewModel,"Add to favorites")

            Btn(text = "My Cocktails") {

                navController.navigate("UserCocktailScreen")

            }

            Btn(text = "Logout/Home") {

                navController.navigate("HomeScreen")

            }

        }

    }

}

