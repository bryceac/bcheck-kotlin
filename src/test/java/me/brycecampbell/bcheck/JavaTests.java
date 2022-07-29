package me.brycecampbell.bcheck;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaTests {
    @Test
    public void createEmptyTransaction() {
        Transaction transaction = new Transaction();

        assert transaction.getType() == TransactionType.Withdrawal;
    }

    @Test
    public void createNewRecord() {
        Record record = new Record();

        assert !record.getId().isEmpty();
    }

    @Test
    public void retrieveRecordsFromFile() {
        List<Record> expected_records = new ArrayList<>(Arrays.asList(
                new Record("FF04C3DC-F0FE-472E-8737-0F4034C049F0",
                        new Transaction("2021-07-08", 1260, null,
                                "Sam Hill Credit Union", "Open Account", 500.0,
                                TransactionType.Deposit, false)),
                new Record("1422CBC6-7B0B-4584-B7AB-35167CC5647B",
                        new Transaction("2021-07-08", 1260, null,
                                "Fake Street Electronics", "Head set", 200.0,
                                TransactionType.Withdrawal, false)),
                new Record("BB22187E-0BD3-41E8-B3D8-8136BD700865",
                        new Transaction("2021-07-08", 1260, null,
                                "Velociraptor Entertainment", "Pay Day", 50000.0,
                                TransactionType.Deposit, false))
        ));

        List<Record> records = Record.loadFromPath("/Users/bryce/Desktop/test.bcheck");

        assert  records.size() == expected_records.size();
    }

    @Test
    public void saveRecordsToFile() {
        List<Record> records = new ArrayList<>(Arrays.asList(
                new Record("FF04C3DC-F0FE-472E-8737-0F4034C049F0",
                        new Transaction("2021-07-08", 1260, "Opening Balance",
                                "Sam Hill Credit Union", "Open Account", 500.0,
                                TransactionType.Deposit, true)),
                new Record("1422CBC6-7B0B-4584-B7AB-35167CC5647B",
                        new Transaction("2021-07-08", 1260, "Gifts",
                                "Fake Street Electronics", "Head set", 200.0,
                                TransactionType.Withdrawal, false)),
                new Record("BB22187E-0BD3-41E8-B3D8-8136BD700865",
                        new Transaction("2021-07-08", 1260, null,
                                "Velociraptor Entertainment", "Pay Day", 50000.0,
                                TransactionType.Deposit, false))
        ));

        saveToPath.saveToPath(records, "/Users/bryce/Desktop/test.bcheck");

        File store = new File("/Users/bryce/Desktop/test.bcheck");

        assert store.exists();
    }
}
