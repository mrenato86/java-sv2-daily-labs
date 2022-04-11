package day04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairFinder {

    public int findPairs(int[] arr) {
        int[] array = Arrays.copyOf(arr, arr.length);
        Arrays.sort(array);
        int pairs = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                pairs++;
                i++;
            }
        }
        return pairs;
    }

    public int findPairsStream(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toMap(n -> n, n -> 1, Integer::sum))
                .values().stream()
                .mapToInt(v -> v / 2)
                .sum();
    }

    public int findPairsStreamList(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toMap(v -> v, v -> 1, Integer::sum))
                .values().stream()
                .mapToInt(v -> v / 2)
                .sum();
    }

}
