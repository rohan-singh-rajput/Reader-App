package com.rohan.areader.presentation.navigation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rohan.areader.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderHomeScreen(navController: NavController) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Reader ",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = androidx.compose.ui.Modifier.padding(top = 2.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = androidx.compose.ui.Modifier.fillMaxSize()
            ) {
                //Home
                Text(text = "Hello")
            }
        },
        floatingActionButton = {
            FABContent {

            }

        }


    )
}


@Composable
fun FABContent(onTap: () -> Unit) {
    FloatingActionButton(
        onClick = { onTap },
        shape = RoundedCornerShape(50),
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add A Book",
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )

    }
}


