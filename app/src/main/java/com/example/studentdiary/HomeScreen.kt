package com.example.studentdiary

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studentdiary.ui.theme.StudentDetailsColor

val taskLists = mapOf(
    "Attendance" to R.drawable.ic_action_attendance,
    "Fees Paid" to R.drawable.ic_action_fees,
    "Internal Marks" to R.drawable.ic_action_internal_marks,
    "Library" to R.drawable.ic_action_library,
    "Grievance" to R.drawable.ic_action_grievance,
    "Subjects" to R.drawable.ic_action_subjects,
    "Profile" to R.drawable.ic_action_profile
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar(navController)
        }
    ){
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = 8.dp,
                border = BorderStroke(1.dp,StudentDetailsColor.blue)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.school_picture),
                    contentDescription = "School Image",
                    contentScale = ContentScale.FillWidth
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 20.dp),
                text = stringResource(id = R.string.elementary_school),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                color = StudentDetailsColor.blue,
                fontWeight = FontWeight.Bold
            )
            CardComponent(navController)
        }
    }
}

@Composable
fun TopBar(navController: NavHostController){

    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = stringResource(id = R.string.home)) },
        backgroundColor = StudentDetailsColor.blue,
        contentColor = Color.White,
        actions = {
            IconButton(
                onClick = { showMenu = !showMenu },
                modifier = Modifier
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "Menu Icon",
                    tint = Color.White
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    onClick = { navController.navigate(Profile.route) }
                ) {
                    Text(text = stringResource(id = R.string.profile))
                }
                DropdownMenuItem(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Login.route)
                    }
                ) {
                    Text(text = stringResource(id = R.string.log_out))
                }
            }
        }
    )
}

@Composable
fun IndividualComponent(taskName: String, taskIcon: Int, navController: NavHostController){
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = {
            when(taskName){
                "Profile" -> navController.navigate(Profile.route)
                "Fees Paid" -> navController.navigate(FeesPaid.route)
                else -> Toast.makeText(context,"$taskName Icon is clicked!!",Toast.LENGTH_SHORT).show()
            }
        }) {
            Icon(
                painter = painterResource(id = taskIcon),
                contentDescription = "Icon",
                tint = StudentDetailsColor.blue
            )
        }
        Text(
            text = taskName
        )
    }
}

@Composable
fun CardComponent(navController: NavHostController) {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(bottom = 10.dp),
            columns = GridCells.Fixed(3)
        ){
            for ( (taskName,taskIcon) in taskLists){
                items(1){
                    IndividualComponent(taskName = taskName, taskIcon = taskIcon, navController = navController)
                }
            }
        }
    }
}
