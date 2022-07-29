package me.brycecampbell.bcheck;

import org.junit.jupiter.api.Test;

public class BCheckTests {
    @Test
    public void createEmptyTransaction() {
        Transaction transaction = new Transaction();

        assert transaction.getType() == TransactionType.Withdrawal;
    }
}
