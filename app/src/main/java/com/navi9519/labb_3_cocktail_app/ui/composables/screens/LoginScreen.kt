package com.navi9519.labb_3_cocktail_app.ui.composables.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.navi9519.labb_3_cocktail_app.R
import com.navi9519.labb_3_cocktail_app.ui.composables.AccountOrNot
import com.navi9519.labb_3_cocktail_app.ui.composables.Btn
import com.navi9519.labb_3_cocktail_app.ui.composables.SignInInputField
import com.navi9519.labb_3_cocktail_app.ui.composables.Title
import com.navi9519.labb_3_cocktail_app.ui.theme.GoldColor

@Composable
@Preview(showBackground = true)
fun LoginScreen() {

    var hej = "Hej"

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.signup_background),
            contentDescription = "Login-background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .zIndex(-10f))


        Column(modifier = Modifier
            .fillMaxSize()
            .zIndex(10f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Title(
                "Login",

                60.sp,

                 Stroke(
                    miter = 10f,
                    width = 16f,
                    join = StrokeJoin.Miter
                ),
                Shadow(
                    color = Color.Black,
                    offset = Offset(-16f, 16f),
                    blurRadius = 8f
                )
            )

            // Username input field logic
            SignInInputField(TextFieldValue("",),
                { newValue -> hej = newValue.toString() },
                icon = "person",
                placeholder = "E-mail",
               )

            // Password input field logic
            SignInInputField(TextFieldValue(),
                { newValue -> hej = newValue.toString() },
                icon = "lock",
               placeholder = "Password",
                visual = PasswordVisualTransformation()
                )
            Btn("Login") {

                  }
            AccountOrNot(
                text = "Don't have an account? Sign up"
            )
        }

    }
}


