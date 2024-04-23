package com.navi9519.labb_3_cocktail_app.ui.composables.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.ui.composables.Btn
import com.navi9519.labb_3_cocktail_app.ui.composables.SignInInputField
import com.navi9519.labb_3_cocktail_app.ui.composables.SignInTitle

@Composable
@Preview(showBackground = true)
fun SignUpScreen() {

    var hej = "Hej"

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.signup_background),
            contentDescription = "Login-background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()  

        )


        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInTitle("Sign Up")

            // Username input field logic
            SignInInputField(
                TextFieldValue("Hej"),
                { newValue -> hej = newValue.toString() },
                icon = "person",
                label = "Username",
            )

            SignInInputField(
                TextFieldValue("Hej"),
                { newValue -> hej = newValue.toString() },
                icon = "email",
                label = "E-mail",
            )

            // Password input field logic
            SignInInputField(
                TextFieldValue("Hej"),
                { newValue -> hej = newValue.toString() },
                icon = "lock",
                label = "Password",
                visual = PasswordVisualTransformation()
            )

            SignInInputField(
                TextFieldValue("Hej"),
                { newValue -> hej = newValue.toString() },
                icon = "lock",
                label = "Confirm Password",
                visual = PasswordVisualTransformation()
            )
            Btn("Sign Up") {

            }

        }

    }

}