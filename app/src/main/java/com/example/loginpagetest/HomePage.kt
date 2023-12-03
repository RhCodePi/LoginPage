package com.example.loginpagetest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.loginpagetest.ui.theme.LoginPageTestTheme
import com.example.loginpagetest.ui.theme.Orange

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
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            horizontalArrangement = Arrangement.End
        ){
            Surface(
                modifier = Modifier.size(412.dp,75.dp),
                shape = RectangleShape,
                color = Orange,
            ) {
                Row (
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center
                ){
                    Surface (
                        modifier = Modifier.size(75.dp),
                        shape = RectangleShape,
                        color = Color.Red,
                    ){

                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    Surface (
                        modifier = Modifier.size(75.dp),
                        shape = RectangleShape,
                        color = Color.Red,
                    ){

                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(25.dp))
        Surface(
            modifier = Modifier.size(150.dp),
        ) {
        }

    }




    /*Column (
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
        verticalArrangement = Arrangement.SpaceEvenly,
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
        Surface(
            modifier = Modifier
                .size(
                    100.dp
                ),
            color = Color.Red,
        ) {

        }



    }*/
}