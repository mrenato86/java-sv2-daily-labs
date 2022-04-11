package day04;

import java.util.ArrayList;
import java.util.List;

public class Prison {

    private final int numOfCells;
    private final int numOfDays;
    private final boolean[] cells;
    private final List<Integer> prisonersReleased;
    private boolean isPrisonersReleased;

    public Prison(int numOfCells, int numOfDays) {
        this.numOfCells = numOfCells;
        this.numOfDays = numOfDays;
        this.cells = new boolean[numOfCells];
        this.prisonersReleased = new ArrayList<>();
    }

    private boolean isValidStructure() {
        return (numOfCells > 0 && numOfDays > 0);
    }

    private void switchCell(int cellNumber) {
        cells[cellNumber] = !cells[cellNumber];
    }

    private void releaseForDay(int day) {
        for (int cellNum = day - 1; cellNum < cells.length; cellNum += day) {
            switchCell(cellNum);
        }
    }

    private void releaseMethod() {
        for (int day = 1; day <= numOfDays; day++) {
            releaseForDay(day);
        }
        isPrisonersReleased = true;
    }

    private void setListOfPrisonersReleased(){
        for (int cellNum = 0; cellNum < cells.length; cellNum++) {
            if(cells[cellNum]) {
                prisonersReleased.add(cellNum + 1);
            }
        }
    }

    public List<Integer> getListOfPrisonersReleased() {
        if(isPrisonersReleased) {
            return prisonersReleased;
        }
        if (!isValidStructure()) {
            return null;
        }
        releaseMethod();
        setListOfPrisonersReleased();
        return prisonersReleased;
    }

    public boolean isPrisonersReleased() {
        return isPrisonersReleased;
    }

    public void openFreeCells(){
        List<Integer> listOfOpenCells= getListOfPrisonersReleased();
        if (listOfOpenCells != null) {
            System.out.println(listOfOpenCells.size() + " prisoners were released, from cells:");
            System.out.println(listOfOpenCells);
        }
        else {
            System.out.println("Invalid Prison!");
        }
    }

}
