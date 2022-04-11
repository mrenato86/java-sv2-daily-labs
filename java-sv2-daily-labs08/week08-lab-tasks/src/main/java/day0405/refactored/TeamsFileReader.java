package day0405.refactored;

import java.nio.file.Path;
import java.util.List;

public class TeamsFileReader extends AbstractFileReader {

    @Override
    public Path getPath() {
        return Path.of("src/main/resources/day04/datamunging/football.dat");
    }

    @Override
    public List<Integer> getFilteredIndexes() {
        return List.of(0, 18);
    }

    @Override
    public Position getNamePosition() {
        return new Position(7, 23);
    }

    @Override
    public Position getValue1Position() {
        return new Position(43, 45);
    }

    @Override
    public Position getValue2Position() {
        return new Position(50, 52);
    }
}
