package com.example.studentdiary

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studentdiary.ui.theme.StudentDetailsColor

@Composable
fun FeesPaidScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(stringResource(id = R.string.fees_paid),navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                backgroundColor = StudentDetailsColor.blue,
                contentColor = Color.White,
                elevation = 10.dp
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    text = "ACADEMIC FEES",
                    textAlign = TextAlign.Center
                )
            }
            Card(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = StudentDetailsColor.cloud,
                shape = RoundedCornerShape(10.dp)
            ) {
                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total Academic Fees",
                            style = MaterialTheme.typography.h6,
                            color = StudentDetailsColor.blue
                        )
                        Text(
                            text = "5000.0",
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
                            text = "Paid Fees",
                            style = MaterialTheme.typography.h6,
                            color = StudentDetailsColor.blue
                        )
                        Text(
                            text = "0.0",
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
                            text = "Balance Fees",
                            style = MaterialTheme.typography.h6,
                            color = StudentDetailsColor.blue
                        )
                        Text(
                            text = "5000.0",
                            style = MaterialTheme.typography.h6
                        )
                    }
                }
            }
        }
    }

}
