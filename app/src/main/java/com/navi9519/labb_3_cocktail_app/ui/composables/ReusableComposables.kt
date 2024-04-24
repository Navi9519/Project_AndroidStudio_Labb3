package com.navi9519.labb_3_cocktail_app.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_3_cocktail_app.ui.theme.ChampagneGoldColor
import com.navi9519.labb_3_cocktail_app.ui.theme.GoldColor
import com.navi9519.labb_3_cocktail_app.ui.theme.MidnightBlue


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
            fontStyle = FontStyle.Italic

            )
    }
}



//// Login/Signup Composables ////

@Composable
fun Title(
    title: String,
    fontSize: TextUnit,
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
            )
        },

        visualTransformation = visual ?: VisualTransformation.None


    )

}


@Composable
fun AccountOrNot(text: String) {
    
    Text( modifier = Modifier
        .padding(top = 20.dp),
        text = text,
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