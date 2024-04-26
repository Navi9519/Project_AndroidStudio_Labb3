    package com.navi9519.labb_3_cocktail_app.ui.composables

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
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.graphics.painter.Painter
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.window.Dialog
    import androidx.lifecycle.viewmodel.compose.viewModel
    import coil.compose.AsyncImage
    import com.navi9519.labb_3_cocktail_app.ui.viewmodels.DrinksViewModel


    @Composable
    fun TestApi(/*viewModel: DrinksViewModel = viewModel()*/) {

        CocktailCard(
            onDismissRequest = { /*TODO*/ },
            onConfirmation = { /*TODO*/ },

        )

      /*  val drinksObject by viewModel.drinksUiState

        // Trigger fetch on initial composition
        LaunchedEffect(true) {
            viewModel.fetchDrinks()
        }

        if (drinksObject != null) {
            val cocktailImg = drinksObject?.drinks?.get(0)?.cocktailImg
            val cocktailName = drinksObject?.drinks?.get(0)?.cocktailName.toString()
            val cocktailCategory = drinksObject?.drinks?.get(0)?.cocktailCategory.toString()
            val cocktailInstructions = drinksObject?.drinks?.get(0)?.cocktailInstructions.toString()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = cocktailImg,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape)
                )
                Text(text = cocktailName)
                Text(text = cocktailCategory)
                Text(text = cocktailInstructions)

            }
        } else {
            Text(text = "Loading...")
        } */
    }


