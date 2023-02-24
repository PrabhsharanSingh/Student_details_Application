package com.example.studentdiary

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studentdiary.ui.theme.StudentDetailsColor

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(stringResource(id = R.string.profile),navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            StudentCard()
        }
    }
}

@Composable
fun TopBar(name: String,navController: NavHostController){
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                textAlign = TextAlign.Justify
            )
                },
        backgroundColor = StudentDetailsColor.blue,
        contentColor = Color.White,
        navigationIcon = {
                         IconButton(
                             onClick = {
                                 navController.popBackStack(Home.route,true)
                                 navController.navigate(Home.route)
                             }
                         ) {
                             Icon(
                                 Icons.Default.ArrowBack,
                                 contentDescription = "Arrow Back Icon"
                             )
                         }
        }
    )
}

@Composable
fun StudentCard(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = StudentDetailsColor.cloud,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = studentDetailsList.get(0).name,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
            Divider(
                color = StudentDetailsColor.blue
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Roll No",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = studentDetailsList.get(0).rollNo.toString(),
                    style = MaterialTheme.typography.h6
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Phone No",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = studentDetailsList.get(0).phoneNo.toString(),
                    style = MaterialTheme.typography.h6
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Course",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = studentDetailsList.get(0).course,
                    style = MaterialTheme.typography.h6
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var isExpanded by remember { mutableStateOf(false) }
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Email Id",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { isExpanded = !isExpanded },
                    text = studentDetailsList.get(0).email,
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var isExpanded by remember { mutableStateOf(false) }
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Address",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { isExpanded = !isExpanded },
                    text = studentDetailsList.get(0).address,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "City",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = studentDetailsList.get(0).city,
                    style = MaterialTheme.typography.h6
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "State",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = studentDetailsList.get(0).state,
                    style = MaterialTheme.typography.h6
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Country",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = studentDetailsList.get(0).country,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}
