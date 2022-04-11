package day02;

public class MathAlgorithms {

    public int gcdBruteForce(int a, int b) {
        int gcd = 1;
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public int gcdEuclideanRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdEuclideanRecursion(b, a % b);
    }

    public int gcdEuclideanDivision(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int gcdEuclideanSubtraction(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else
                b -= a;
        }
        return a;
    }

}
