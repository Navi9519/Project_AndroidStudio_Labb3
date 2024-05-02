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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.model.database.user.User
import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
import com.navi9519.labb_3_cocktail_app.view.composables.AccountOrNot
import com.navi9519.labb_3_cocktail_app.view.composables.Btn
import com.navi9519.labb_3_cocktail_app.view.composables.SignInInputField
import com.navi9519.labb_3_cocktail_app.view.composables.Title
import kotlinx.coroutines.Dispatchers


@Composable
//@Preview(showBackground = true)
fun SignUpScreen(
    navController: NavController,

) {

    // Mutable textField states for username and password
    val usernameState = remember { mutableStateOf(TextFieldValue("")) }
    val emailState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordState= remember { mutableStateOf(TextFieldValue("")) }


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
                usernameState.value,
                { newValue -> usernameState.value = newValue },
                icon = "person",
                placeholder = "Username",
            )

            // Email input field logic
            SignInInputField(
                emailState.value,
                { newValue -> emailState.value = newValue },
                icon = "email",
                placeholder = "E-mail",
            )

            // Password input field logic
            SignInInputField(
                passwordState.value,
                { newValue -> passwordState.value = newValue },
                icon = "lock",
                placeholder = "Password",
                visual = PasswordVisualTransformation()
            )

            SignInInputField(
                passwordState.value,
                { newValue -> passwordState.value = newValue },
                icon = "lock",
                placeholder = "Confirm Password",
                visual = PasswordVisualTransformation()
            )


            Btn("Sign Up") {

                // Setting more easy readable variables for state changes
                val username = usernameState.value.text
                val email = emailState.value.text
                val password = passwordState.value.text


                if (username.length >= 2 && email.length >= 10 && password.length >= 6) {

                    // Check if the username already exists i users(list)

                    // Add new User object
                    val newUser = User(email, username, password)

                    // Update the userDatabase state, with the new user
                    

                }
            }

            Row() {
                AccountOrNot(
                    text = "Allready have a account? ",
                    account = " Login",
                    onClick = {
                        navController.navigate("LoginScreen")
                    }
                )
            }


        }

    }

}