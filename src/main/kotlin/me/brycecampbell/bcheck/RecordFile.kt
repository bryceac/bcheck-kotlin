@file:JvmMultifileClass
@file:JvmName("Record")

package me.brycecampbell.bcheck
import java.io.File
import java.nio.file.Paths

/**
 * load record data from a given path.
 * The input contained in the file is expected to be that of array.
 */
fun Record.Companion.loadFromPath(path: String): MutableList<Record> {
    val specifiedPath = Paths.get(path)
    val content = File(specifiedPath.toAbsolutePath().toString())

    return decodeFromString(content.readText()).toMutableList()
}