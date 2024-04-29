package com.navi9519.labb_3_cocktail_app.view.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.view.composables.AccountOrNot
import com.navi9519.labb_3_cocktail_app.view.composables.Btn
import com.navi9519.labb_3_cocktail_app.view.composables.SignInInputField
import com.navi9519.labb_3_cocktail_app.view.composables.Title

@Composable
@Preview(showBackground = true)
fun SignUpScreen() {

    var hej = "Hej"

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state = rememberScrollState())
    ) {

        Image(
            painter = painterResource(R.drawable.signup_background),
            contentDescription = "Login-background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()

        )


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp,),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Title(
                "Sign Up",

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
                )
            )


            // Username input field logic
            SignInInputField(
                TextFieldValue(),
                { newValue -> hej = newValue.toString() },
                icon = "person",
                placeholder = "Username",
            )

            SignInInputField(
                TextFieldValue(),
                { newValue -> hej = newValue.toString() },
                icon = "email",
               placeholder = "E-mail",
            )

            // Password input field logic
            SignInInputField(
                TextFieldValue(),
                { newValue -> hej = newValue.toString() },
                icon = "lock",
               placeholder = "Password",
                visual = PasswordVisualTransformation()
            )

            SignInInputField(
                TextFieldValue(),
                { newValue -> hej = newValue.toString() },
                icon = "lock",
                placeholder = "Confirm Password",
                visual = PasswordVisualTransformation()
            )


            Btn("Sign Up") {

            }


            Row() {
                AccountOrNot(
                    text = "Allready have a account? ",
                    account = " Login"
                )
            }


        }

    }

}