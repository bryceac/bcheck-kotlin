package me.brycecampbell.bcheck

import com.benasher44.uuid.uuid4
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.io.File
import java.nio.file.Paths
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Record object represents a transaction entry for ledgers, with all the necessary details.
 * the previous record field is set to be ignored in JSON input to ensure that things are up to date.
 */
@Serializable
data class Record @JvmOverloads constructor(val id: String = uuid4().toString(),
                  @EncodeDefault var transaction: Transaction = Transaction()) {

    companion object {
        /**
         * decode a list of records from a given string.
         * This method is used to help facilitate deserializing records from JSON,
         * which can help reduce code needed to create an import method as needed.
         */
        @JvmStatic
        fun decodeFromString(text: String): List<Record> {
            return Json.decodeFromString<MutableList<Record>>(text)
        }

        @JvmStatic
        fun loadFromPath(path: String): MutableList<Record> {
            val specifiedPath = Paths.get(path)
            val content = File(specifiedPath.toAbsolutePath().toString())

            return decodeFromString(content.readText()).toMutableList()
        }
    }
}