package day05;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransferAggregatorTest {

    @Test
    void testReadTransfers() throws IOException {
        TransferAggregator transferAggregator = new TransferAggregator();
        List<String> result = transferAggregator.readTransfers(Path.of("src/main/resources/transfers.csv"))
                .stream()
                .map(TransferPerClient::toString)
                .map(s -> s.replaceAll("\u00a0", " "))
                .toList();
        List<String> expected = Files.readAllLines(Path.of("src/main/resources/transfers-sum.txt"));

        assertEquals(expected, result);
    }
}