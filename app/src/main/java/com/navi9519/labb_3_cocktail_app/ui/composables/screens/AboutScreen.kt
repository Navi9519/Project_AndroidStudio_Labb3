package com.navi9519.labb_3_cocktail_app.ui.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.ui.composables.Btn
import com.navi9519.labb_3_cocktail_app.ui.composables.SignInInputField
import com.navi9519.labb_3_cocktail_app.ui.composables.Title
import com.navi9519.labb_3_cocktail_app.ui.theme.GoldColor

@Composable
@Preview(showBackground = true)
fun AboutScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = R.drawable.about_background),
            contentDescription = "About-background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .zIndex(-1f)
                .shadow((-20).dp)

            )
        Column(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,


        ) {
Title(
    title = "About",

    60.sp,

    null,

    Stroke(
        miter = 10f,
        width = 16f,
        join = StrokeJoin.Miter
    ),
    Shadow(
        color = Color.Black,
        offset = Offset(-16f, 16f),
        blurRadius = 8f
    ),

)

            Text(
                text = "Welcome to our Cocktail App! Discover the art of mixology with ease." +
                        " Browse through a vast collection of cocktail recipes, each curated to perfection." +
                        " From classic favorites to trendy concoctions, we've got it all." +
                        " Explore detailed ingredient lists and step-by-step instructions for every drink." +
                        " Save your favorite cocktails for quick access later." +
                        " Whether you're a seasoned bartender or a casual enthusiast," +
                        " our app is your ultimate companion for mixing up delightful drinks." +
                        " Cheers!" ,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = GoldColor,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                maxLines = 12,
                style = LocalTextStyle.current.copy(
                    lineHeight = 40.sp,
                    lineBreak = LineBreak.Paragraph,
                    shadow =  Shadow(
                        color = Color.Black,
                        offset = Offset(-1f, 1f),
                        blurRadius = 8f
                    )
                ),

                modifier = Modifier
                    .padding(top = 5.dp, bottom = 20.dp)
                    .width(350.dp)
            )

            Btn(text = "Login/Sign up") {

            }

        }

    }

}