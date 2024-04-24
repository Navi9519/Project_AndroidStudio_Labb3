package com.navi9519.labb_3_cocktail_app.ui.composables

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.navi9519.labb_3_cocktail_app.ui.theme.GoldColor
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp


@Composable
@Preview(showBackground = true)
fun Test(
) {
    // This box just wraps the background and the OutlinedTextField
    Box {
        // This box works as background
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(top = 8.dp) // adding some space to the label
                .background(
                    color = GoldColor,
                    // rounded corner to match with the OutlinedTextField
                    shape = RoundedCornerShape(4.dp)
                )
        )
        // OutlineTextField will be the content...
      SignInInputField()
    }
}




@Composable
fun SignInInputField(
) {



    return OutlinedTextField(
        value = "input",
        modifier = Modifier
            .padding(vertical = 30.dp)
            .background(color = androidx.compose.ui.graphics.Color.White,)
        ,

        textStyle = TextStyle(
            GoldColor,
            fontStyle = FontStyle.Italic,
            fontSize = 20.sp),

        leadingIcon = {
            Icon(
                imageVector = getLoginIcon(iconName = "lock"),
                contentDescription = " Icon",
                tint = GoldColor
            ) },

        onValueChange = {
           "Text"


        },





    )

}