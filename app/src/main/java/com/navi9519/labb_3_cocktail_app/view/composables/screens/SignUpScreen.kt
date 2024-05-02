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
import kotlinx.coroutines.flow.collect


@Composable
//@Preview(showBackground = true)
fun SignUpScreen(
    navController: NavController,
    userRepository: UserRepository

) {


// Mutable textField states for username, email, and password
    val emailState = remember { mutableStateOf(TextFieldValue("")) }
    val usernameState = remember { mutableStateOf(TextFieldValue("")) }
    val passwordState = remember { mutableStateOf(TextFieldValue("")) }

    // Function to add user to the database and print all users

    fun addUserAndPrintUsers() {
        // Get the values from the text field states
        val email = emailState.value.text
        val username = usernameState.value.text
        val password = passwordState.value.text

        // Check if the username, email, and password are valid
        if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {

            // Add the user to the database
            userRepository.performDatabaseOperation(Dispatchers.IO) {
                val newUser = User(email, username, password)
                userRepository.insertOrUpdateUser(newUser)
            }


            // Print all users
            userRepository.performDatabaseOperation(Dispatchers.Main) {
                userRepository.findAllUsers().collect { users ->
                    println("All users:")
                    users.forEach {
                        println("${it.email} - ${it.name} - ${it.password} ${it.id} ")
                    }
                    userRepository.findAllUsers().collect{
                        println(it)
                    }
                }
                }
            navController.navigate("LoginScreen")

        }
    }


    Box(
        modifier = Modifier
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


        Column(
            modifier = Modifier
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


            // Email input field logic
            SignInInputField(
                emailState.value,
                { newValue -> emailState.value = newValue },
                icon = "email",
                placeholder = "E-mail",
            )

            // Username input field logic
            SignInInputField(
                usernameState.value,
                { newValue -> usernameState.value = newValue },
                icon = "person",
                placeholder = "Username",
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

                addUserAndPrintUsers()
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
