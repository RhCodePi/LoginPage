package com.example.loginpagetest.presentation

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
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.loginpagetest.R
import com.example.loginpagetest.data.userList
import com.example.loginpagetest.ui.theme.LoginPageTestTheme


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPageTestTheme {
        LoginPage(
            navController =  rememberNavController()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavController
)
{
    val focusManager = LocalFocusManager.current
    Column (
        modifier = Modifier
            .size(412.dp, 732.dp) //
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.White,
                        Color.Blue
                    )
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.trakyalogo),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.height(20.dp))

        var emailValue by rememberSaveable{
            mutableStateOf("")
        }
        TextField(
            value = emailValue,
            onValueChange = {emailValue = it},
            modifier = Modifier
                .fillMaxWidth(0.75f),
            keyboardOptions = KeyboardOptions(
                keyboardType =  KeyboardType.Email,
                imeAction = ImeAction.Go,
            ),
            keyboardActions = KeyboardActions(
                onGo = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            label = {
                Text(
                    stringResource(R.string.label_email)
                )
            },
            shape = RoundedCornerShape(80.dp),
            maxLines = 1,
            placeholder = {
                Text(
                    stringResource(R.string.placeholder_email)
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
            modifier = Modifier
                .fillMaxWidth(0.75f),
            keyboardOptions = KeyboardOptions(
                keyboardType =  KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            label = {
                Text(stringResource(R.string.label_password))
            },
            placeholder = {
                Text(stringResource(R.string.placeholder_password))
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
            onClick = {
                      enterFunc(emailValue, passwordValue, navController)
            },
            modifier = Modifier
                .size(175.dp, 35.dp),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(31, 75, 255),
            )
        )
        {
            Text(text = "Enter")
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}


fun enterFunc(email : String,password : String ,navControl: NavController)
{
    for(user in userList)
    {
        if(email == user.getUserEmail())
        {
            if(password == user.getUserPassword())
            {
                navControl.navigate(route = Screen.Home.route)
                user.getUserDetail().isLogged = true
            }
        }
    }
}