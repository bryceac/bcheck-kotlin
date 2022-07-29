@file:JvmName("encodeRecords")

package me.brycecampbell.bcheck

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.jvm.JvmName

/**
 * encode a list of records to a JSON string.
 * This method is used to help facilitate serializing record objects to JSON,
 * which can help reduce code needed to create an export method as needed.
 */
fun MutableList<Record>.encodeToJSONString(): String {
    return Json { prettyPrint = true }.encodeToString(this)
}