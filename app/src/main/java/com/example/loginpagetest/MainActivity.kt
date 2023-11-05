package com.example.loginpagetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpagetest.ui.theme.LoginPageTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          CommentTextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPageTestTheme {
        CommentTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentTextField()
{
    Column (
        modifier = Modifier
            .size(500.dp, 500.dp)
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color.Blue
                    )
                )
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.trakyalogo),
            contentDescription = "Image",
            modifier = Modifier
                .size(150.dp)
                .shadow(1.dp, CircleShape),
        )
        Spacer(modifier = Modifier.height(20.dp))

        var emailValue by rememberSaveable{
            mutableStateOf("")
        }
        TextField(
            value = emailValue,
            onValueChange = {emailValue = it},
            modifier = Modifier.fillMaxWidth(0.75f),
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Email),
            label = {
                Text(
                    "Enter Email",
                )
            },
            shape = RoundedCornerShape(80.dp),
            maxLines = 1,
            placeholder = {
                Text(
                    text = "example@trakya.edu.tr"
                )
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            },
        )
        Spacer(modifier = Modifier.height(20.dp))
        var passwordValue by rememberSaveable{
            mutableStateOf("")
        }
        var isPasswordVisible by rememberSaveable{ mutableStateOf(true) }
        TextField(
            value = passwordValue,
            onValueChange = {passwordValue= it},
            modifier = Modifier.fillMaxWidth(0.75f),
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
            label = {
                Text(text = "Enter Password")
            },
            placeholder = {
                Text(text ="*********")
            },
            shape = RoundedCornerShape(80.dp),
            maxLines = 1,
            visualTransformation = if(isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Password")
            },
            trailingIcon = {
                val image = if(isPasswordVisible){
                    Icons.Filled.Visibility
                }else
                    Icons.Filled.VisibilityOff

                IconButton(
                    onClick = { isPasswordVisible = !isPasswordVisible }
                ) {
                    Icon(imageVector = image, contentDescription = "visibility")
                }
            }
        )
        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(175.dp, 35.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(31, 75, 255),
            )

        )
        {
            Text(text = "Enter")
        }
    }

}