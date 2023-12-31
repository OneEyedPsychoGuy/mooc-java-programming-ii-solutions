package validating;

public class Calculator {
    public int factorial(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("Factorial only works for positive numbers!");
        }

        int fact = 1;
        for(int i = 1; i <= num; i++) {
            fact *= i;
        }

        return fact;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if(setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("Set size or subset size was negative!");
        } else if(subsetSize > setSize) {
            throw new IllegalArgumentException("Subset size exceeds set size!");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}