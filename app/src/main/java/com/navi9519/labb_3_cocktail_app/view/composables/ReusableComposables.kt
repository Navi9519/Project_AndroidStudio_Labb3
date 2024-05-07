    package com.navi9519.labb_3_cocktail_app.view.composables

    import androidx.compose.foundation.BorderStroke
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Email
    import androidx.compose.material.icons.filled.Lock
    import androidx.compose.material.icons.filled.Person
    import androidx.compose.material.icons.filled.Warning
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.Card
    import androidx.compose.material3.Icon
    import androidx.compose.material3.LocalTextStyle
    import androidx.compose.material3.OutlinedTextField
    import androidx.compose.material3.OutlinedTextFieldDefaults
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.geometry.Offset
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.Shadow
    import androidx.compose.ui.graphics.drawscope.Stroke
    import androidx.compose.ui.graphics.vector.ImageVector
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontStyle
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.input.PasswordVisualTransformation
    import androidx.compose.ui.text.input.TextFieldValue
    import androidx.compose.ui.text.input.VisualTransformation
    import androidx.compose.ui.text.style.LineBreak
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.text.style.TextDecoration
    import androidx.compose.ui.unit.TextUnit
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.ui.window.Dialog
    import androidx.lifecycle.viewmodel.compose.viewModel
    import coil.compose.AsyncImage
    import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
    import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import com.navi9519.labb_3_cocktail_app.view.theme.GoldColor
    import com.navi9519.labb_3_cocktail_app.viewmodels.DrinksViewModel
    import com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel.UserViewModel
    import kotlinx.coroutines.Dispatchers
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.collectAsState
    import com.navi9519.labb_3_cocktail_app.model.database.relation.UserWithCocktails
    import com.navi9519.labb_3_cocktail_app.model.database.user.User


    // Reusable button composable for all screens
    @Composable
    fun Btn(text: String, onclick: () -> Unit) {
        Button(onClick = onclick,
            colors = ButtonDefaults.buttonColors(GoldColor),
            border = BorderStroke(1.dp, color = Color.White),
            modifier = Modifier
                .width(250.dp)
                .padding(20.dp)

        )  {

            Text(
                text = text,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic

                )
        }
    }



    //// Login/Signup Composables ////

    @Composable
    fun Title(
        title: String,
        fontSize: TextUnit,
        fontWeight: FontWeight? = null,
        drawstyle: Stroke? = null,
        shadow: Shadow? = null
    ) {

        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 80.dp),
            style = TextStyle.Default.copy(
                color = GoldColor,
                fontSize = fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = fontWeight,
                textAlign = TextAlign.Center,
                lineBreak = LineBreak.Paragraph,
                lineHeight = 70.sp,
                drawStyle = drawstyle,
                shadow = shadow
            ),
        )


    }


    @Composable
    fun SignInInputField(
        input: TextFieldValue,
        onValueChange: (TextFieldValue) -> Unit,
        icon: String,
        placeholder: String,
        label: String? = null,
        visual: PasswordVisualTransformation? = null
    ) {



        return OutlinedTextField(
            value = input,
            modifier = Modifier
                .padding(vertical = 30.dp)
                .background(color = GoldColor, RoundedCornerShape(22.dp))
            ,
            shape = RoundedCornerShape(22.dp)
            ,


            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.White,
                unfocusedBorderColor = Color.White,
                unfocusedLabelColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,

                ),

            textStyle = TextStyle(
                Color.White,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp,
            ),

            leadingIcon = {
                Icon(
                    imageVector = getLoginIcon(icon),
                    contentDescription = "$icon Icon",
                    tint = Color.White
                ) },

            onValueChange = {
                onValueChange(it)

            },

            placeholder = {
                Text(
                    placeholder,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },

            visualTransformation = visual ?: VisualTransformation.None


        )

    }


    @Composable
    fun AccountOrNot(text: String, account: String, onClick: () -> Unit) {

        Text( modifier = Modifier
            .padding(top = 20.dp),
            text = text,
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                color = GoldColor,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(-16f, 16f),
                    blurRadius = 8f
                )
            )
        )

        Text( modifier = Modifier
            .padding(top = 20.dp)
            .clickable(onClick = onClick),
            text = account,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                color = GoldColor,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(-16f, 16f),
                    blurRadius = 8f
                )
            )
        )

    }

    // Get Icon function for input field

    fun getLoginIcon(iconName: String): ImageVector {
        return when (iconName) {
            "person" -> Icons.Default.Person
            "lock" -> Icons.Default.Lock
            "email" -> Icons.Default.Email
            else -> Icons.Default.Warning
        }

    }



    @Composable
    fun BtnAddOrRemove(text: String, onClick: () -> Unit) {

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(GoldColor),
            border = BorderStroke(1.dp, color = Color.White),
            modifier = Modifier
                .size(width = 130.dp, height = 35.dp)
                .padding(vertical = 1.dp)
        ) {
            Text(
                text = text,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                color = Color.White,

                )
        }

    }


    /// Components for rendering cocktails
    @Composable
    fun FindCocktailList(
        viewModel: DrinksViewModel = viewModel(),
        text: String,
        userViewModel: UserViewModel,
        userRepository: UserRepository
    ) {
        val drinksList by viewModel.drinksUiState

        val username = userViewModel.username.value
        val userId = userViewModel.userId.longValue

        // Trigger fetch on initial composition
        LaunchedEffect(true) {
            viewModel.fetchRandomCocktails(10)
        }

        if (drinksList.isNotEmpty()) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .padding(horizontal = 40.dp)
            ) {
                items(drinksList) { drink ->
                    drink?.drinks?.forEach { cocktail ->
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Invoke CocktailListItem composable
                            CocktailListItem(
                                cocktailName = cocktail.cocktailName,
                              /*  onClick = {
                                    // Invoke CocktailCard composable
                                   CocktailCard(
                                        cocktailImg = cocktail.cocktailImg,
                                        cocktailName = cocktail.cocktailName,
                                        cocktailCategory = cocktail.cocktailCategory,
                                        cocktailInstructions = cocktail.cocktailInstructions,
                                        onDismissRequest = {},
                                        onConfirmation = {}
                                    )

                                }


                               */

                            )
                            BtnAddOrRemove(
                                text,
                                onClick = {

                                    userRepository.performDatabaseOperation(Dispatchers.IO) {
                                        userRepository.saveCocktail(
                                            Cocktail( cocktail.cocktailImg,
                                                cocktail.cocktailName,
                                                cocktail.cocktailCategory,
                                                cocktail.cocktailInstructions,
                                                userId
                                            )
                                        )
                                    }

                                }
                            )
                        }
                    }
                }
            }
        } else {
            Text(
                text = "Loading...",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = GoldColor,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                style = LocalTextStyle.current.copy(
                    shadow =  Shadow(
                        color = Color.Black,
                        offset = Offset(-1f, 1f),
                        blurRadius = 8f
                    )
                ))
        }
    }




    @Composable
    fun UserCocktailList(
        text: String,
        userViewModel: UserViewModel,
        userRepository: UserRepository
    ) {

        val userId = userViewModel.userId.longValue
        val userName = userViewModel.username.value
        // Collect user's cocktails from the repository
        val userCocktails by userRepository.findCocktails(userName).collectAsState(initial = null
        )



        if (userCocktails != null && userCocktails!!.cocktails.isNotEmpty()) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .padding(horizontal = 40.dp, vertical = 20.dp)
            ) {
                items(userCocktails!!.cocktails) { cocktail ->
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Invoke CocktailListItem composable
                            cocktail.cocktailName?.let {
                                CocktailListItem(
                                    cocktailName = it,
                                )
                            }
                            BtnAddOrRemove(
                                text,
                                onClick = {

                                }
                            )
                    }
                }
            }
        } else {
            Text(
                text = "No Cocktails added",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = GoldColor,
                fontFamily = FontFamily.Default,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                style = LocalTextStyle.current.copy(
                    shadow =  Shadow(
                        color = Color.Black,
                        offset = Offset(-1f, 1f),
                        blurRadius = 8f
                    )
                ))
        }
    }



    @Composable
    fun CocktailListItem(
        cocktailImg: String? = null,
        cocktailName: String,
        cocktailCategory: String? = null,
        cocktailInstructions: String? = null,
      // onClick: () -> Unit,
    ) {

        val maxLength = 20

        Text(
            modifier = Modifier.
            clickable(onClick = {

            } )
            ,
            text = cocktailName.take(maxLength),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = GoldColor,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            style = LocalTextStyle.current.copy(
                shadow =  Shadow(
                    color = Color.Black,
                    offset = Offset(-1f, 1f),
                    blurRadius = 8f
                )
            )
        )
    }




    @Composable
    fun CocktailCard(
        cocktailImg: String,
        cocktailName: String,
        cocktailCategory: String,
        cocktailInstructions: String,
        onDismissRequest: () -> Unit,
       onConfirmation: () -> Unit,

        ) {



            Dialog(onDismissRequest = { onDismissRequest() }) {
                // Draw a rectangle shape with rounded corners inside the dialog
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(375.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            model = cocktailImg,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(shape = CircleShape)
                        )
                        Text(
                            text = cocktailName
                        )
                        Text(
                            text = cocktailCategory
                        )
                        Text(
                            text = cocktailInstructions
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            TextButton(
                                onClick = { onDismissRequest() },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Back")
                            }
                            TextButton(
                                onClick = { onConfirmation() },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Add Drink")
                            }
                        }
                    }
                }
            }
        }

/*
    // Cocktail modal
    @Composable
    fun CocktailCard(
        viewModel: DrinksViewModel = viewModel(),
        onDismissRequest: () -> Unit,
        onConfirmation: () -> Unit,

        ) {
        val drinksObject by viewModel.drinksUiState

        // Trigger fetch on initial composition
        LaunchedEffect(true) {
            viewModel.fetchRandomCocktails(1)
        }

        if (drinksObject.isNotEmpty()) {
            val cocktailImg = drinksObject[0]?.drinks?.get(0)?.cocktailImg
            val cocktailName = drinksObject[0]?.drinks?.get(0)?.cocktailName.toString()
            val cocktailCategory = drinksObject[0]?.drinks?.get(0)?.cocktailCategory.toString()
            val cocktailInstructions = drinksObject[0]?.drinks?.get(0)?.cocktailInstructions.toString()
            Dialog(onDismissRequest = { onDismissRequest() }) {
                // Draw a rectangle shape with rounded corners inside the dialog
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(375.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        AsyncImage(
                            model = cocktailImg,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(shape = CircleShape)
                        )
                        Text(
                            text = cocktailName
                        )
                        Text(
                            text = cocktailCategory
                        )
                        Text(
                            text = cocktailInstructions
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            TextButton(
                                onClick = { onDismissRequest() },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Back")
                            }
                            TextButton(
                                onClick = { onConfirmation() },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Add Drink")
                            }
                        }
                    }
                }
            }
        } else {
            Text(text = "Loading...")
        }
    }

    */
