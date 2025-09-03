package com.example.fileexplorer.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fileexplorer.ui.components.filetree.FileTreeView

@Composable
fun FileExplorerDrawer(
    drawerState: DrawerState,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(300.dp)
            .padding(16.dp)
    ) {
        // Заголовок
        Text(
            text = "File Explorer",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // Кнопки действий
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { /* Открыть папку */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(Icons.Default.Folder, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Open Folder")
            }
            
            IconButton(onClick = { /* Обновить */ }) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
            }
        }
        
        Spacer(Modifier.height(16.dp))
        
        // Дерево файлов
        FileTreeView(
            rootNode = remember { createSampleFileTree() },
            onFileClick = { /* Обработка клика по файлу */ }
        )
    }
}
