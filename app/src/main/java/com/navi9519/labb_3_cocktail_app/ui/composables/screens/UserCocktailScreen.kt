package com.navi9519.labb_3_cocktail_app.ui.composables.screens

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
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.ui.composables.Btn
import com.navi9519.labb_3_cocktail_app.ui.composables.CocktailList
import com.navi9519.labb_3_cocktail_app.ui.theme.GoldColor

@Composable
@Preview(showBackground = true)
fun UserCocktailScreen() {

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
                text = "Hello UserName",
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
            CocktailList("Remove")

            Btn(text = "Find cocktails") {

            }

            Btn(text = "Logout/Home") {

            }



        }

    }


}