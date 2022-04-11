package day04;

import java.util.ArrayList;
import java.util.List;

public class PrisonOther {

    private final int numOfCells;
    private final int numOfDays;
    private final List<Integer> prisonersReleased;
    private boolean isPrisonersReleased;

    public PrisonOther(int numOfCells, int numOfDays) {
        this.numOfCells = numOfCells;
        this.numOfDays = numOfDays;
        this.prisonersReleased = new ArrayList<>();
    }

    private boolean isValidStructure() {
        return (numOfCells > 0 && numOfDays > 0);
    }

    private int numOfDivisors(int cellNum) {
        int numOfDivisors = 0;
        for (int i = 1; i <= cellNum && i<=numOfDays; i++){
            if (cellNum % i == 0)
               numOfDivisors++;
        }
        return numOfDivisors;
    }
    //Possible Improvement
    private int numOfDivisorsUnderLimit(int cellNum) {
        int numOfDivisors = 0;
        for (int i = 1; i <= Math.sqrt(cellNum); i++) {
            if (cellNum % i == 0) {
                int division = cellNum / i;
                if (division == i || division > numOfDays)
                    numOfDivisors++;
                else
                    numOfDivisors += 2;
            }

        }
        return numOfDivisors;
    }

    private void setListOfPrisonersReleased() {
        for (int cellNum = 1; cellNum <= numOfCells; cellNum++) {
            if (numOfDivisorsUnderLimit(cellNum) % 2 != 0) {
                prisonersReleased.add(cellNum);
            }
        }
        isPrisonersReleased = true;
    }

    public List<Integer> getListOfPrisonersReleased(){
        if(isPrisonersReleased) {
            return prisonersReleased;
        }
        if (!isValidStructure()) {
            return null;
        }
        setListOfPrisonersReleased();
        return prisonersReleased;

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
