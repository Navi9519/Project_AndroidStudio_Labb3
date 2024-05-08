    package com.navi9519.labb_3_cocktail_app.view.composables.screens

    import androidx.compose.foundation.Image
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
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextButton
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.remember
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.window.Dialog
    import androidx.navigation.NavController
    import coil.compose.AsyncImage
    import com.navi9519.labb_3_cocktail_app.model.database.cocktail.Cocktail
    import com.navi9519.labb_3_cocktail_app.model.database.user.UserRepository
    import com.navi9519.labb_3_cocktail_app.viewmodels.userViewModel.UserViewModel


    @Composable
    fun CocktailCardScreen(
        navController: NavController,
        userViewModel: UserViewModel,
        userRepository: UserRepository,
        cocktailName: String?
        /*  cocktailImg: String?,
           cocktailName: String?,
           cocktailCategory: String?,
           cocktailInstructions: String?,

         */
        // Add any other necessary parameters
      //  onDismissRequest: () -> Unit,
       // onConfirmation: () -> Unit,

        ) {

        val userName = userViewModel.username.value



        // Find the cocktail details using the UserRepository
        val cocktailDetails by userRepository.findCocktail(cocktailName ?: "").collectAsState(initial = null)




        Dialog(onDismissRequest = {  }) {
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
                        model = cocktailDetails?.cocktailImg,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(shape = CircleShape)
                    )




                    Text(
                        text = cocktailName  ?: ""
                    )
                    cocktailDetails?.cocktailCategory?.let {
                        Text(
                            text = it
                        )
                    }
                    cocktailDetails?.cocktailInstructions?.let {
                        Text(
                            text = it
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextButton(
                            onClick = { },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("Back")
                        }
                        TextButton(
                            onClick = {  },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text("Add Drink")
                        }
                    }
                }
            }
        }
    }
