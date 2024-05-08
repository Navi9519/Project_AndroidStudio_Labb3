    package com.navi9519.labb_3_cocktail_app.view.composables.screens

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Card
    import androidx.compose.material3.LocalTextStyle
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.geometry.Offset
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.Shadow
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.text.style.TextDecoration
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.ui.window.Dialog
    import androidx.navigation.NavController
    import coil.compose.AsyncImage
    import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
    import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import com.navi9519.labb_3_cocktail_app.view.theme.GoldColor
    import com.navi9519.labb_3_cocktail_app.view.theme.OliveGreen
    import com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel.UserViewModel


    @Composable
    fun CocktailCardScreen(
        navController: NavController,
        userRepository: UserRepository,
        cocktailName: String?

        ) {

        // Find the cocktail details using the UserRepository
        val cocktailDetails by userRepository.findCocktail(cocktailName ?: "").collectAsState(initial = null)


        Dialog(
            onDismissRequest = {  }) {
            // Draw a rectangle shape with rounded corners inside the dialog
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(color = OliveGreen),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = OliveGreen),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AsyncImage(
                        model = cocktailDetails?.cocktailImg,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.
                            padding(vertical = 20.dp)
                            .size(280.dp)
                            .clip(shape = CircleShape)
                    )




                    Text(
                        modifier = Modifier.padding(vertical = 20.dp),
                        text = cocktailName  ?: "",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldColor,
                        fontFamily = FontFamily.Default,
                        textAlign = TextAlign.Center,
                        style = LocalTextStyle.current.copy(
                            shadow =  Shadow(
                                color = Color.Black,
                                offset = Offset(-1f, 1f),
                                blurRadius = 8f
                            )
                        )
                    )
                    cocktailDetails?.cocktailCategory?.let {
                        Text(
                            modifier = Modifier.padding(vertical = 20.dp),
                            text = it,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldColor,
                            fontFamily = FontFamily.Default,
                            textAlign = TextAlign.Center,
                            style = LocalTextStyle.current.copy(
                                shadow =  Shadow(
                                    color = Color.Black,
                                    offset = Offset(-1f, 1f),
                                    blurRadius = 8f
                                )
                            )
                        )
                    }
                    cocktailDetails?.cocktailInstructions?.let {
                        Text(
                            modifier = Modifier.padding(vertical = 20.dp),
                            text = it,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = GoldColor,
                            fontFamily = FontFamily.Default,
                            textAlign = TextAlign.Center,
                            style = LocalTextStyle.current.copy(
                                shadow =  Shadow(
                                    color = Color.Black,
                                    offset = Offset(-1f, 1f),
                                    blurRadius = 8f
                                )
                            )
                        )
                    }
                        TextButton(
                            onClick = { navController.popBackStack()},
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text(
                                "Back",
                                fontSize = 25.sp,
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

                }
            }
        }
    }
