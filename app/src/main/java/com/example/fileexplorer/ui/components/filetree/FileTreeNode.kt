package com.example.fileexplorer.ui.components.filetree

import java.io.File

data class FileTreeNode(
    val file: File,
    val children: List<FileTreeNode> = emptyList()
)

fun createFileTreeFromPath(file: File): FileTreeNode {
    return if (file.isDirectory) {
        val children = file.listFiles()
            ?.filter { it.exists() }
            ?.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() }))
            ?.map { createFileTreeFromPath(it) }
            ?: emptyList()
        
        FileTreeNode(file, children)
    } else {
        FileTreeNode(file)
    }
}

fun createSampleFileTree(): FileTreeNode {
    val root = File("/storage/emulated/0")
    return FileTreeNode(
        file = root,
        children = listOf(
            FileTreeNode(File("/storage/emulated/0/Download"), emptyList()),
            FileTreeNode(File("/storage/emulated/0/Documents"), emptyList()),
            FileTreeNode(File("/storage/emulated/0/Pictures"), emptyList())
        )
    )
}
