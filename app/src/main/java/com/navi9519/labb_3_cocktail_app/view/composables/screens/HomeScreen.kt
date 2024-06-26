package com.navi9519.labb_3_cocktail_app.view.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.view.composables.Btn
import com.navi9519.labb_3_cocktail_app.view.composables.Title





@Composable
//@Preview(showBackground = true)
fun HomeScreen(
    navController: NavController
) {


Box(modifier = Modifier
    .fillMaxSize()
    .verticalScroll(state = rememberScrollState())

)
{

    Image(
        painter = painterResource(id = R.drawable.homescreen_background),
        contentDescription = "About-background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .matchParentSize()
            .zIndex(-1f)
            .shadow((-20).dp)

    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.logo_3),
            contentDescription = "Login-background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(350.dp)
                .shadow(1.dp)
        )

        Title(
            title = "Find your favourite Cocktails here!",
            40.sp,

            fontWeight = FontWeight.Bold,

           null,

            Shadow(
                color = Color.Black,
                offset = Offset(-16f, 16f),
                blurRadius = 8f
            ),


        )
        
Column (modifier = Modifier
    .padding(bottom = 20.dp)) {
    Btn(text = "About") {
        navController.navigate("AboutScreen")

    }

    Btn(text = "Login/Sign up") {
        navController.navigate("LoginScreen")

    }
}

    }
}
}