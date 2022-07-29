@file:JvmName("saveToPath")

package me.brycecampbell.bcheck

import java.io.BufferedWriter
import java.io.FileWriter
import java.nio.file.Paths

/**
 * save record list to a given path.
 */
fun MutableList<Record>.saveToPath(path: String) {
    val specifiedPath = Paths.get(path).toAbsolutePath()

    val encodedRecords = this.encodeToJSONString()

    val writer = BufferedWriter(FileWriter(specifiedPath.toString()))

    writer.write(encodedRecords)

    writer.close()
}