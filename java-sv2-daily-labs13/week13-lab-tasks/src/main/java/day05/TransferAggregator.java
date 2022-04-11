package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readFromFile(path);
        Map<String, TransferPerClient> result = summarize(lines);
        return new ArrayList<>(result.values());
    }

    private Map<String, TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> result = new TreeMap<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            String sourceClient = parts[0];
            String targetClient = parts[1];
            int amount = Integer.parseInt(parts[2]);
            TransferPerClient source = result.computeIfAbsent(sourceClient, TransferPerClient::new);
            source.decrease(amount);
            TransferPerClient target = result.computeIfAbsent(targetClient, TransferPerClient::new);
            target.increase(amount);
        }
        return result;
    }

    private List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    public static void main(String[] args) {
        TransferAggregator transferAggregator = new TransferAggregator();
        List<TransferPerClient> transfers = transferAggregator.readTransfers(Path.of("src/main/resources/transfers.csv"));
        transfers.forEach(System.out::println);
    }
}
