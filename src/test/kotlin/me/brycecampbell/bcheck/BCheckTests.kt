package me.brycecampbell.bcheck

import org.junit.jupiter.api.Test
import java.io.File

class BCheckTests {
    @Test
    fun createEmptyTransaction() {
        val transaction = Transaction()

        assert(transaction.type == TransactionType.Withdrawal)
    }

    @Test
    fun createNewRecord() {
        val record = Record()

        assert(!record.transaction.isReconciled)
    }

    @Test
    fun retrieveRecordsFromFile() {
        val expectedRecords = listOf(
            Record("FF04C3DC-F0FE-472E-8737-0F4034C049F0",
                Transaction("2021-07-08", 1260,
                null, "Sam Hill Credit Union", "Open Account", 500.0, TransactionType.Deposit, false)
            ),
            Record("1422CBC6-7B0B-4584-B7AB-35167CC5647B",
                Transaction("2021-07-08", 1260,
                    null, "Fake Street Electronics", "Head set", 200.0, TransactionType.Withdrawal, false)
            ),
            Record("BB22187E-0BD3-41E8-B3D8-8136BD700865",
            Transaction("2021-07-08", 1260,
                null, "Velociraptor Entertainment", "Pay Day", 50000.0, TransactionType.Deposit, false)
            )
        )

        val records = Record.loadFromPath("/Users/bryce/Desktop/test.bcheck")

        assert(records.count() == expectedRecords.count())
    }

    @Test
    fun saveRecordsToFile() {
        val records = mutableListOf(
            Record("FF04C3DC-F0FE-472E-8737-0F4034C049F0",
                Transaction("2021-07-08", 1260,
                    "Opening Balance", "Sam Hill Credit Union", "Open Account", 500.0, TransactionType.Deposit, true)
            ),
            Record("1422CBC6-7B0B-4584-B7AB-35167CC5647B",
                Transaction("2021-07-08", 1260,
                    null, "Fake Street Electronics", "Head set", 200.0, TransactionType.Withdrawal, false)
            ),
            Record("BB22187E-0BD3-41E8-B3D8-8136BD700865",
                Transaction("2021-07-08", 1260,
                    null, "Velociraptor Entertainment", "Pay Day", 50000.0, TransactionType.Deposit, false)
            )
        )

        records.saveToPath("/Users/bryce/Desktop/test.bcheck")

        assert(File("/Users/bryce/Desktop/test.bcheck").exists())
    }
}