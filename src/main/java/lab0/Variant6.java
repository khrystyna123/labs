package lab0;

import java.text.DecimalFormat;
import java.util.Objects;

public class Variant6 {

    public static class TwoInts {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TwoInts twoInts = (TwoInts) o;
            return x == twoInts.x &&
                    y == twoInts.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        private int x;

        private int y;

        public TwoInts(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @param c are parallelepiped sides
     * @return square, volume
     */
    public TwoInts inputOutputTask(int a, int b, int c) {
        return new TwoInts(2 * (a * b + b * c + a * c), a * b * c);
    }

    /**
     *
     * @param k is two-digit number
     * @return left and right number
     */

    public TwoInts integerNumbersTask(int k) {
        return new TwoInts(k / 10, k % 10);
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return true, if a < b < c
     */
    public boolean booleanTask(int a, int b, int c) {
        return a < b && b < c;
    }


    /**
     *
     * @param x
     * @param y are integer numbers
     * @return bigger number
     */
    public int ifTask(int x, int y) {
        if (x >= y)
            return x;
        return y;
    }


    /**
     *
     * @param unit
     * @param number
     * @return number in give unit
     */
    public double switchTask(int unit, double number) {
        switch (unit) {
            case 1 :
                number *= 0.1;
                break;
            case 2 :
                number *= 1000;
                break;
            case 3 :
                break;
            case 4 :
                number *= 0.001;
                break;
            case 5 :
                number *= 0.01;
                break;
            default:
                assert unit < 1 && unit > 5: "Enter number from 1 to 5";
        }

        return number;
    }


    /**
     *
     * @param n is price for kg of candies
     * @return price for 1.2, 1.4, ... , 2 kg
     */
    public double[] forTask(int n) {
        assert n > 0: "Argument should be more than zero";

        double output[] = new double[5];

        int j = 0;
        for (double i = 1.2; i <= 2; i += 0.2) {
            output[j++] = Double.parseDouble(new DecimalFormat("#.#").format(n * i));
        }

        return output;
    }

    /**
     *
     * @param n is integer number
     * @return n * (n - 2) * (n - 4)... factorial
     */
    public int whileTask(int n) {
        assert n > 0: "Argument should be more than zero";

        int factorial = 1;
        while (n > 0) {
            factorial *= n;
            n -= 2;
        }

        return factorial;
    }

    /**
     *
     * @param n is array size
     * @param a
     * @param b first array numbers
     * @return array where all numbers are sum of all previous numbers
     */
    public double[] arrayTask(int n, int a, int b) {
        assert n > 1: "Argument should be more than one";

        double[] array = new double[n];

        array[0] = a;
        array[1] = b;

        for (int i = 2; i < n; i++) {
            array[i] = (i - 1) * (a + b);
        }

        return array;
    }

    /**
     *
     * @param m
     * @param n
     * @param q
     * @param numbers
     * @return array, where element on the next line equals element on previous line multiplied by q
     */
    public int[][]  twoDimensionArrayTask(int m, int n, int q, int[] numbers) {
        assert n > 0 && m > 0: "Arguments should be more than zero";
        assert numbers.length >= n: "Array should have n element";

        int array[][] = new int[m][n];

        array[0] = numbers;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = q * array[i - 1][j];
            }
        }

        return array;
    }

}