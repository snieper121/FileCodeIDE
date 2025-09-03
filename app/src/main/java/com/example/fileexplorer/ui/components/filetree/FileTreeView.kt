package com.example.fileexplorer.ui.components.filetree

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun FileTreeView(
    rootNode: FileTreeNode,
    modifier: Modifier = Modifier,
    onFileClick: (FileTreeNode) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            FileTreeNodeItem(
                node = rootNode,
                depth = 0,
                onFileClick = onFileClick
            )
        }
    }
}


@Composable
private fun FileTreeNodeItem(
    node: FileTreeNode,
    depth: Int,
    onFileClick: (FileTreeNode) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { 
                if (node.file.isDirectory) {
                    isExpanded = !isExpanded
                } else {
                    onFileClick(node)
                }
            }
            .padding(start = (depth * 16).dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (node.file.isDirectory) {
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .rotate(if (isExpanded) 90f else 0f)
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Folder,
                contentDescription = null,
                tint = if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
        } else {
            Icon(
                imageVector = Icons.Default.InsertDriveFile,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        
        Spacer(Modifier.width(8.dp))
        
        Text(
            text = node.file.name,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
    
    // Показываем дочерние элементы если папка развернута
    if (node.file.isDirectory && isExpanded) {
        node.children.forEach { childNode ->
            FileTreeNodeItem(
                node = childNode,
                depth = depth + 1,
                onFileClick = onFileClick
            )
        }
    }
}
