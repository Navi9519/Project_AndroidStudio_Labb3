    package com.navi9519.labb_3_cocktail_app.view.composables.screens

    import com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel.UserViewModel
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
    import androidx.compose.runtime.LaunchedEffect
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
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.ui.zIndex
    import androidx.navigation.NavController
    import com.navi9519.labb_3_cocktail_app.R
    import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import com.navi9519.labb_3_cocktail_app.view.composables.AccountOrNot
    import com.navi9519.labb_3_cocktail_app.view.composables.Btn
    import com.navi9519.labb_3_cocktail_app.view.composables.SignInInputField
    import com.navi9519.labb_3_cocktail_app.view.composables.Title
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.coroutineScope
    import kotlinx.coroutines.flow.collect
    import kotlinx.coroutines.withContext


    @Composable
    //@Preview(showBackground = true)
    fun LoginScreen(
        navController: NavController,
        userViewModel: UserViewModel,

    ) {

        val usernameState = remember { mutableStateOf(TextFieldValue("")) }
        val passwordState = remember { mutableStateOf(TextFieldValue("")) }



        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
        ) {

            Image(
                painter = painterResource(id = R.drawable.signup_background),
                contentDescription = "Login-background",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .zIndex(-10f))


            Column(modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
                .zIndex(10f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Title(
                    "Login",

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
                SignInInputField(usernameState.value,
                    { newValue -> usernameState.value = newValue },
                    icon = "person",
                    placeholder = "Username",
                   )

                // Password input field logic
                SignInInputField(passwordState.value,
                    { newValue -> passwordState.value = newValue},
                    icon = "lock",
                   placeholder = "Password",
                    visual = PasswordVisualTransformation()
                    )

                Btn("Login") {
                    val username = usernameState.value.text
                    val password = passwordState.value.text

                    userViewModel.login(username, password) { isUserLoggedIn ->
                        if (isUserLoggedIn) {

                            userViewModel.username.value = username         // TODO - From TEXT_EDIT
                            userViewModel.setUserIDbyUsername(username)     //

                            navController.navigate("FindCocktailScreen")
                        } else {
                            println("Invalid username or password")
                        }
                    }
                }

                Row {
                    AccountOrNot(
                        text = "Don't have an account? ",
                        account = " Sign up",
                        onClick = {
                            navController.navigate("SignUpScreen")
                        }
                    )
    }

            }

        }
    }


