package day0405.refactored;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileReader {

    public String findSmallestDifferenceName() {
        List<String> lines = readFile(getPath());
        lines = filterLines(lines, getFilteredIndexes());
        List<DataGeneral> data = extractData(lines,
                getNamePosition(), getValue1Position(), getValue2Position());
        return findMin(data).getId();
    }

    public abstract Path getPath();

    public abstract List<Integer> getFilteredIndexes();

    public abstract Position getNamePosition();

    public abstract Position getValue1Position();

    public abstract Position getValue2Position();

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("File reading error!", ioe);
        }
    }

    private List<String> filterLines(List<String> lines, List<Integer> toFilter) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (!toFilter.contains(i)) {
                result.add(lines.get(i));
            }
        }
        return result;
    }

    private List<DataGeneral> extractData(List<String> lines, Position namePos, Position value1Pos, Position value2Pos) {
        List<DataGeneral> result = new ArrayList<>();
        for (String line : lines) {
            result.add(new DataGeneral(
                    namePos.getAsString(line),
                    value1Pos.getAsInt(line),
                    value2Pos.getAsInt(line)
            ));
        }
        return result;
    }

    private DataGeneral findMin(List<DataGeneral> data) {
        DataGeneral min = data.get(0);
        for (DataGeneral item : data) {
            if (min.getDifference() > item.getDifference()) {
                min = item;
            }
        }
        return min;
    }

}
