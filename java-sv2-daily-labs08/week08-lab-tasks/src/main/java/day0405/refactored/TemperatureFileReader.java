package day0405.refactored;

import java.nio.file.Path;
import java.util.List;

public class TemperatureFileReader extends AbstractFileReader {

    @Override
    public Path getPath() {
        return Path.of("src/main/resources/day04/datamunging/weather.dat");
    }

    @Override
    public List<Integer> getFilteredIndexes() {
        return List.of(0, 1, 32);
    }

    @Override
    public Position getNamePosition() {
        return new Position(2, 4);
    }

    @Override
    public Position getValue1Position() {
        return new Position(6, 8);
    }

    @Override
    public Position getValue2Position() {
        return new Position(12, 14);
    }
}
