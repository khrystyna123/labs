package test;

import lab0.Variant6;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class TestVariant6 {

    @Test
    public void MassTest() {
        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    public void loginOld() {
        assertEquals(new Variant6().booleanTask(3, 2, 8), false);
    }

    @Test(dataProvider = "inputProvider")
    public void inputTest(int p1, int p2, int p3, Variant6.TwoInts p4) {
        assertEquals(new Variant6().inputOutputTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] inputProvider() {
        return new Object[][]{{2, 4, 6, new Variant6.TwoInts(88, 48)},
                {6, 3, 12, new Variant6.TwoInts(252, 216)}};
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, Variant6.TwoInts p2) {
        assertEquals(new Variant6().integerNumbersTask(p1), p2);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][]{{10, new Variant6.TwoInts(1, 0)},
                {12, new Variant6.TwoInts(1, 2)}, {39, new Variant6.TwoInts(3, 9)}};
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3) {
        assertEquals(new Variant6().ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{{2, 3, 3}, {1, 1, 1}, {-3, -5, -3}};
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, int p3, boolean p4) {
        assertEquals(new Variant6().booleanTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{5, 6, 7, true}, {0, 5, 3, false}, {-3, 6, 2, false}};
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, double p2, double p3) {
        assertEquals(new Variant6().switchTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]{{3, 654, 654}, {5, 6, 0.06}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant6().switchTask(10, 8);
    }

    ///////////////////////////////////////////////////


    @Test(dataProvider = "forProvider")
    public void forTest(int n, double[] p1) {
        assertEquals(new Variant6().forTask(n), p1);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{3, new double[]{3.6, 4.2, 4.8, 5.4, 6}},
                {7, new double[]{8.4, 9.8, 11.2, 12.6, 14}},
                {12, new double[]{14.4, 16.8, 19.2, 21.6, 24}}};
    }

    @Test(dataProvider = "negativeForProvider", expectedExceptions = AssertionError.class)
    public void forNegativeTest(int n) {
        new Variant6().forTask(n);
    }


    @DataProvider
    public Object[][] negativeForProvider() {
        return new Object[][]{{0}, {-2}};
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int b) {
        assertEquals(new Variant6().whileTask(a), b);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]{{10, 3840}, {7, 105}, {1, 1}, {5, 15}};
    }

    @Test(dataProvider = "negativeWhileProvider", expectedExceptions = AssertionError.class)
    public void whileNegativeTest(int a) {
        new Variant6().whileTask(a);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][]{{0}, {-2}};
    }

    //////////////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int n, int value1, int value2, double[] output) {
        assertEquals(new Variant6().arrayTask(n, value1, value2), output);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]{{3, 10, 6, new double[]{10, 6, 16}}, {4, 1, 2, new double[]{1, 2, 3, 6}},
                {6, 4, 3, new double[]{4, 3, 7, 14, 21, 28}}};
    }

    @Test(dataProvider = "negativeArrayProvider", expectedExceptions = AssertionError.class)
    public void arrayNegativeTest(int a, int b, int c) {
        new Variant6().arrayTask(a, b, c);
    }

    @DataProvider
    public Object[][] negativeArrayProvider() {
        return new Object[][]{{1, 2, 9}, {-27, 1, 5}};
    }

    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int m, int n, int q, int[] numbers, int[][] output) {
        assertArrayEquals(new Variant6().twoDimensionArrayTask(m, n, q, numbers), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[] input = {4, -2, 0};

        int[][] input23 = {{4, -2, 0},
                {8, -4, 0},
                {16, -8, 0},
                {32, -16, 0}};

        int[][] input14 = {{4, -2, 0},
                {16, -8, 0},
                {64, -32, 0}};

        return new Object[][]{{4, 3, 2, input, input23}, {3, 3, 4, input, input14}};

    }

    @Test(dataProvider = "negativeTwoDimensionArrayProvider", expectedExceptions = AssertionError.class)
    public void twoDimensionArrayNegativeTest(int m, int n, int q, int[] numbers) {
       new Variant6().twoDimensionArrayTask(m, n, q, numbers);
    }

    @DataProvider
    public Object[][] negativeTwoDimensionArrayProvider() {
        return new Object[][]{{0, -2, 4, new int[]{1, 2, 9}}, {1, 6, 5, new int[]{1}}};
    }

    @Test
    public void arrayTest2() {
        assertEquals(new int[]{2, 3}, new int[]{2, 3});
    }
}