package com.example.studentdiary

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studentdiary.ui.theme.StudentDetailsColor

@Composable
fun LoginScreen(navController: NavHostController) {
    val localManger = LocalFocusManager.current
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .clickable { localManger.clearFocus() }
    ) {
        Image(
            modifier = Modifier.fillMaxHeight(0.5f),
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = "Login Image",
            alignment = Alignment.TopStart
        )

        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.login),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = StudentDetailsColor.blue
            )

            var userName by rememberSaveable { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisibility by rememberSaveable { mutableStateOf(false) }

            val icon = if(passwordVisibility)
                painterResource(id = R.drawable.ic_action_password)
            else
                painterResource(id = R.drawable.ic_action_password_on)

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp, bottom = 10.dp),
                label = { Text(text = stringResource(id = R.string.user_name)) },
                value = userName,
                onValueChange = { userName = it },
                singleLine = true,
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_action_name),
                        contentDescription = "User Icon",
                        tint = StudentDetailsColor.blue
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                label = { Text(text = stringResource(id = R.string.password)) },
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = "Visibility Icon",
                            tint = StudentDetailsColor.blue
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (passwordVisibility)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation()
            )

            Button(
                onClick = {
                    if(userName.isEmpty() || password.isEmpty()){
                        Toast.makeText(context,"Username or password must not be empty",Toast.LENGTH_SHORT).show()
                    }else if(password.length < 6){
                        Toast.makeText(context,"Minimum length of 6 required for password",Toast.LENGTH_SHORT).show()
                    }else{
                        navController.popBackStack()
                        navController.navigate(Home.route)
                    }
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(StudentDetailsColor.blue)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        }
    }
}
