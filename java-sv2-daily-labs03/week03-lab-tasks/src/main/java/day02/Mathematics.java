package day02;

import java.util.ArrayList;
import java.util.List;

public class Mathematics {

    public boolean isPrime(int number) {
        number = Math.abs(number);
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Mathematics m = new Mathematics();
        List<Integer> primes = new ArrayList<>();
        List<Integer> notPrimes = new ArrayList<>();
        int target = 20;
        int start = -8;
        for (int i = start ; i < target; i++) {
            if (m.isPrime(i))
                primes.add(i);
            else
                notPrimes.add(i);
        }
        System.out.println("Primes till " + target + ":\n" + primes + "\n");
        System.out.println("Not primes till " + target + ":\n" + notPrimes);
    }

}
