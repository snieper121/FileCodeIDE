package com.example.fileexplorer.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3TopAppBarApi::class)
@Composable
fun MainTopBar(
    onMenuClick: () -> Unit
) {
    TopAppBar(
        title = { Text("File Explorer") },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Поиск */ }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        }
    )
}
