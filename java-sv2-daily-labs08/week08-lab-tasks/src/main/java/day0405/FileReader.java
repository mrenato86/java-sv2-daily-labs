package day0405;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    private List<Data> extractDataFromList(List<String> lines) {
        List<Data> dataList = new ArrayList<>();
        for (int i = 2; i < lines.size() - 1; i++) {
            int day = Integer.parseInt(lines.get(i).substring(2, 4).strip());
            int max = Integer.parseInt(lines.get(i).substring(6, 8).strip());
            int min = Integer.parseInt(lines.get(i).substring(12, 14).strip());
            dataList.add(new Data(day, min, max));
        }
        return dataList;
    }

    public int findSmallestTemperatureSpread(Path path) {
        List<Data> dataList = extractDataFromList(readFile(path));
        Data smallestSpread = dataList.get(0);
        for (Data dataLine : dataList) {
            if (dataLine.getSpread() < smallestSpread.getSpread()) {
                smallestSpread = dataLine;
            }
        }
        return smallestSpread.getDay();
    }

    private List<DataFootball> extractDataFootballFromList(List<String> lines) {
        List<DataFootball> dataList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            if (i != 18) {
                String team = lines.get(i).substring(7, 23).strip();
                int F = Integer.parseInt(lines.get(i).substring(43, 45).strip());
                int A = Integer.parseInt(lines.get(i).substring(50, 52).strip());
                dataList.add(new DataFootball(team, F, A));
            }
        }
        return dataList;
    }

    public String findSmallestDifference(Path path) {
        List<DataFootball> dataList = extractDataFootballFromList(readFile(path));
        DataFootball smallestDifference = dataList.get(0);
        for (DataFootball dataLine : dataList) {
            if (dataLine.getDiff() < smallestDifference.getDiff()) {
                smallestDifference = dataLine;
            }
        }
        return smallestDifference.getTeam();
    }

}
