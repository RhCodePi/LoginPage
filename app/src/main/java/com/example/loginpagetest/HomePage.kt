package com.example.loginpagetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.trakyalogo),
            contentDescription = "Image",
            modifier = Modifier
                .size(75.dp)
                .shadow(1.dp, CircleShape),
        )
    }
}