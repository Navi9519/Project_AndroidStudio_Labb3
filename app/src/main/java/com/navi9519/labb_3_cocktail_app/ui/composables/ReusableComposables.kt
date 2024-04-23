package com.navi9519.labb_3_cocktail_app.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.navi9519.labb_3_cocktail_app.ui.theme.ChampagneGoldColor
import com.navi9519.labb_3_cocktail_app.ui.theme.GoldColor
import com.navi9519.labb_3_cocktail_app.ui.theme.MidnightBlue


// Reusable button composable for all screens
@Composable
fun Btn(text: String, onclick: () -> Unit) {
    Button(onClick = onclick,
        colors = ButtonDefaults.buttonColors(Color.White),
        border = BorderStroke(1.dp, Color.White),
        modifier = Modifier
            .width(250.dp)
            .padding(20.dp)

    )  {

        Text(
            text = text,
            color = GoldColor,
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic

            )
    }
}



//// Login/Signup Composables ////

@Composable
fun SignInTitle(title: String) {

    // TODO - > Fix Styling, fill with gold color and border color black
    Text(
        text = title,
        modifier = Modifier
            .padding(bottom = 80.dp),
        style = TextStyle.Default.copy(
            color = GoldColor,
            fontSize = 60.sp,
            fontStyle = FontStyle.Italic,
            drawStyle = Stroke(
                miter = 15f,
                width = 10f,
                join = StrokeJoin.Round,

            ),
        )
    )


}


@Composable
fun SignInInputField(
    input: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    icon: String,
    label: String,
    visual: PasswordVisualTransformation? = null
) {


    return OutlinedTextField(
        value = input,
        modifier = Modifier
            .padding(vertical = 30.dp)
            .background(Color.White, RoundedCornerShape(22.dp))
        ,
        shape = RoundedCornerShape(22.dp)
        ,
// TODO - > Fix Styling / Border -> Check Hampus resource
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = GoldColor,
            unfocusedBorderColor = GoldColor,
            unfocusedLabelColor = GoldColor,
            unfocusedLeadingIconColor = GoldColor,
            focusedBorderColor = GoldColor,
            focusedLabelColor = GoldColor,


            ),

        textStyle = TextStyle(
            GoldColor,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp),

        leadingIcon = {
            Icon(
                imageVector = getLoginIcon(icon),
                contentDescription = "$icon Icon",
                tint = GoldColor
            ) },

        onValueChange = {
            onValueChange(it)


        },

        label = {
            Text(
                label,
            ) },

        visualTransformation = visual ?: VisualTransformation.None


    )

}

// Get Icon function for input field

private fun getLoginIcon(iconName: String): ImageVector {
    return when (iconName) {
        "person" -> Icons.Default.Person
        "lock" -> Icons.Default.Lock
        "email" -> Icons.Default.Email
        else -> Icons.Default.Warning
    }

}