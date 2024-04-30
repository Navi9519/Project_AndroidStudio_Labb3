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
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.navi9519.labb_3_cocktail_app.model.api.Cocktail
import com.navi9519.labb_3_cocktail_app.model.api.Drinks
import com.navi9519.labb_3_cocktail_app.view.theme.GoldColor
import com.navi9519.labb_3_cocktail_app.viewmodels.DrinksViewModel


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



/// Components for rendering cocktails

@Composable
fun CocktailList(
    viewModel: DrinksViewModel = viewModel(),
    text: String,
    )
{


    val drinksList by viewModel.drinksUiState

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
                    CocktailListItem(cocktailName = cocktail.cocktailName)
                    BtnAddOrRemove(text)
                }

            }
             }
        }
    } else {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CocktailListItem(cocktailName = "No cocktails")
            BtnAddOrRemove(text)
        }

    }
    }



@Composable
fun CocktailListItem(cocktailName: String) {

    Text(
        modifier = Modifier.
        clickable {  },
        text = cocktailName,
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
fun BtnAddOrRemove(text: String) {

    Button(
        onClick = { /*TODO*/ },
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


// Cocktail modal
@Composable
fun CocktailCard(
    viewModel: DrinksViewModel = viewModel(),

    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,

    ) {
    val drinksList by viewModel.drinksUiState

    // Trigger fetch on initial composition
    LaunchedEffect(true) {
        viewModel.fetchRandomCocktails(10)
    }

    if (drinksList.isNotEmpty()) {
        Column {
            drinksList.forEach { drinks ->
                drinks?.drinks?.forEach { cocktail ->
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        // Display cocktail details
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = cocktail.cocktailName)
                            // Display other cocktail details as needed
                        }
                    }
                }
            }
        }
    } else {
        Text(text = "Loading...")
    }
}
