package com.example.loginpagetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.loginpagetest.ui.theme.LoginPageTestTheme

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    LoginPageTestTheme {
        HomePage(navController =  rememberNavController())
    }
}

@Composable
fun HomePage(
    navController: NavController
)
{
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
    ){
        AppBar(navController = navController)
    }
}

@Composable
fun AppBar(
    navController : NavController
)
{
    Row(
        modifier = Modifier
            .size(412.dp, 70.dp)
            .background(
                Color.Red
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Image(
            painter = painterResource(id = R.drawable.cutecat),
            contentDescription = "image_cute_cat",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape),
        )
        Text(
            text = "Home Page"
        )
        ElevatedButton(
            modifier = Modifier,

            onClick = { logOut(navController) }
        ) {
            Text(
                text = "Logout"
            )
        }
    }
}


fun logOut(navControl: NavController)
{
    navControl.navigate(route = Screen.Login.route)
}