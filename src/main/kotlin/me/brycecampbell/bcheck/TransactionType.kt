@file:JvmName("TransactionType")

package me.brycecampbell.bcheck

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmName

/**
 * class that represents the possible types a transaction can be.
 */
@Serializable
enum class TransactionType {
    @SerialName("withdrawal") Withdrawal,
    @SerialName("deposit") Deposit
}