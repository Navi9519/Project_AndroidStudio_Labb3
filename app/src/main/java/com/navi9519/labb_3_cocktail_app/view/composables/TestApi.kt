    package com.navi9519.labb_3_cocktail_app.view.composables

    import androidx.compose.runtime.Composable


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


