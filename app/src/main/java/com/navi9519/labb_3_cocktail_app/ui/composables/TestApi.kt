    package com.navi9519.labb_3_cocktail_app.ui.composables

    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.unit.dp
    import androidx.lifecycle.viewmodel.compose.viewModel
    import coil.compose.AsyncImage
    import com.navi9519.labb_3_cocktail_app.ui.viewmodels.DrinksViewModel


    @Composable
    fun TestApi(viewModel: DrinksViewModel = viewModel()) {
        val drinksObject by viewModel.drinksUiState

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
                Text(text = cocktailName)
                Text(text = cocktailCategory)
                Text(text = cocktailInstructions)
                AsyncImage(
                    model = cocktailImg,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = CircleShape)
                )
            }
        } else {
            Text(text = "Loading...")
        }
    }