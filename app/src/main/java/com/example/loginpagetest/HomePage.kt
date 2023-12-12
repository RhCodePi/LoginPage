package com.example.loginpagetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Assignment
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Grade
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
        verticalArrangement = Arrangement.SpaceBetween,
    ){
        AppBar(navController = navController)

        Row(
            modifier = Modifier
                .size(412.dp, 70.dp)

        ){

        }

        BottomBar()
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

@Composable
fun BottomBar()
{
    Row(
        modifier = Modifier
            .size(412.dp, 70.dp)
            .background(Color.Green),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ){
        Button(
            onClick ={}
        ){
            SetIcon(
                imageVector = Icons.Rounded.CalendarMonth,
                contentDescription = "Calender"
            )
        }

        Button(onClick = { /*TODO*/ }) {
            SetIcon(
                imageVector = Icons.Rounded.Assignment,
                contentDescription = "Assignment"
            )
        }

        Button(onClick = { /*TODO*/ }) {
            SetIcon(
                imageVector = Icons.Rounded.Grade,
                contentDescription = "Grade"
            )
        }
    }
}

@Composable
fun SetIcon(imageVector: ImageVector, contentDescription: String)
{
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(35.dp),
        tint = Color.White
    )
}


fun logOut(navControl: NavController)
{
    navControl.navigate(route = Screen.Login.route)
}