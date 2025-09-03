package com.example.fileexplorer.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fileexplorer.ui.components.FileExplorerDrawer
import com.example.fileexplorer.ui.components.MainTopBar

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                FileExplorerDrawer(
                    drawerState = drawerState,
                    navController = navController
                )
            }
        }
    ) {
        MainTopBar(
            onMenuClick = { /* Открыть drawer */ }
        )
        // Здесь будет основной контент
    }
}
