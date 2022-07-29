@file:JvmName("Transaction")

package me.brycecampbell.bcheck

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayAt
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Transaction object is used to store data pertaining to the transaction being recorded.
 * All fields in the default constructor are optional, but due to compatibility reasons,
 * some fields are marked as necessary for JSON serialization and deserialization.
 */
@Serializable
data class Transaction @JvmOverloads constructor(@EncodeDefault var date: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault()),
                       @SerialName("check_number") var checkNumber: Int? = null,
                       var category: String? = null,
                       @EncodeDefault var vendor: String = "",
                       var memo: String = "",
                       @EncodeDefault var amount: Double = 0.0,
                       @EncodeDefault var type: TransactionType = TransactionType.Withdrawal,
                       @SerialName("is_reconciled") var isReconciled: Boolean = false) {
    /**
     * create a transaction with a specified date in String format.
     * This constructor feeds into the primary constructor everything necessary and converts the given date
     * to a LocalDate for the sake of convenience.
     */
    constructor(date: String,
                checkNumber: Int? = null,
                category: String? = null,
                vendor: String = "",
                memo: String = "",
                amount: Double = 0.0,
                type: TransactionType = TransactionType.Withdrawal,
                isReconciled: Boolean = false): this(LocalDate.parse(date),
        checkNumber, category, vendor, memo, amount, type, isReconciled)
}
