/**
 *  Name: Ying Pei
 *  Date: May 31, 2017
 *  File: RecursionTester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 8.
 *  RecursionTester is a java file 
 *  that tests the functionality of recursion.java
 *  
 */

/**
 * Name:    RecursionTester.java
 * Purpose: To test the functionality of recursion
 */

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionTester {

    // Pretty-print messages
    private static final String PASSED = " Passed!";
    private static final String PASSED_ALL = "Awesooomee!! You passed all tests provided!" +
            "\nNOTE: This does NOT guarantee full points in this part.";
    private static final String NOT_IMPLEMENTED = "Seems like you did not implement this method." +
            "\nIMPORTANT: Do not remove this method from your code.";

    private static final String FAILED = " FAILED. Expected %s, got %s";
    private static final String FAILED_MNEM = " FAILED.\n\tExpected %s\n\tGot      %s";
    private static final String EXCEPTION = " Exception. Oh no! Something bad happened.";
    private static final String RESULT = "[RESULT] Passed %d / %d. Make sure to add more tests!";
    private static final String LINE = "***************************************************";

    private static final String TEST1 = "2";
    private static final String[] TEST1_RES = {"A", "B", "C"};

    private static final String TEST2 = "43";
    private static final String[] TEST2_RES = {"GD", "GE", "GF",
            "HD", "HE", "HF",
            "ID", "IE", "IF"};

    private static final String TEST3 = "019";
    private static final String[] TEST3_RES = {"W", "X", "Y", "Z"};

    private static final String TEST4 = "324#";
    private static final String[] TEST4_RES = {"DAG", "DAH", "DAI",
            "DBG", "DBH", "DBI",
            "DCG", "DCH", "DCI",
            "EAG", "EAH", "EAI",
            "EBG", "EBH", "EBI",
            "ECG", "ECH", "ECI",
            "FAG", "FAH", "FAI",
            "FBG", "FBH", "FBI",
            "FCG", "FCH", "FCI"};

    private static void humanPyramidWeightTester() {

        System.out.println("************** Human Pyramid Weight Tester **************");
        String report = "";
        int score = 0;

        // Create a sample pyramid
        ArrayList<ArrayList<Double>> weights = new ArrayList<ArrayList<Double>>();
        weights.add(new ArrayList<Double>());
        weights.add(new ArrayList<Double>());
        weights.add(new ArrayList<Double>());
        weights.add(new ArrayList<Double>());
        weights.get(0).add(111.3);
        weights.get(1).add(140.3);
        weights.get(1).add(125.3);
        weights.get(2).add(134.2);
        weights.get(2).add(180.9);
        weights.get(2).add(175.6);
        weights.get(3).add(125.3);
        weights.get(3).add(134.2);
        weights.get(3).add(180.9);
        weights.get(3).add(175.6);

        try {
            report += "[TEST #1] humanPyramidWeight(weights, 0, 0) .....";
            double res = Recursion.humanPyramidWeight(weights, 0, 0);
            if (res == 111.3) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 111.3, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #2] humanPyramidWeight(weights, 2, 0) .....";
            double res = Recursion.humanPyramidWeight(weights, 2, 0);
            if (res == 232.175) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 232.175, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #3] humanPyramidWeight(weights, 2, 0) .....";
            double res = Recursion.humanPyramidWeight(weights, 2, 2);
            if (res == 266.075) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 266.075, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #4] humanPyramidWeight(weights, 4, 5) .....";
            double res = Recursion.humanPyramidWeight(weights, 4, 5);
            if (res == 0.0) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 0.0, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }

        if (score == 4) {
            System.out.println(PASSED_ALL);
        } else if (score == 0) {
            System.out.println(NOT_IMPLEMENTED);
        } else {
            System.out.println(report);
        }
        System.out.println("*********************************************************\n");

    }

    private static void generateMnemonicsTester() {

        System.out.println("*************** Generate Mnemonics Tester ***************");
        String report = "";
        int score = 0;

        try {
            report += "[TEST #1] generateMnemonics(" + TEST1 + ") ..................";

            ArrayList<String> res = Recursion.generateMnemonics(TEST1);
            res.sort(null);
            if (Arrays.deepEquals(TEST1_RES, res.toArray())) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED_MNEM, Arrays.toString(TEST1_RES), res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #2] generateMnemonics(" + TEST2 + ") .................";

            ArrayList<String> res = Recursion.generateMnemonics(TEST2);
            res.sort(null);
            if (Arrays.deepEquals(TEST2_RES, res.toArray())) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED_MNEM, Arrays.toString(TEST2_RES), res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #3] generateMnemonics(" + TEST3 + ") ................";

            ArrayList<String> res = Recursion.generateMnemonics(TEST3);
            res.sort(null);
            if (Arrays.deepEquals(TEST3_RES, res.toArray())) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED_MNEM, Arrays.toString(TEST3_RES), res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #4] generateMnemonics(" + TEST4 + ") ...............";

            ArrayList<String> res = Recursion.generateMnemonics(TEST4);
            res.sort(null);
            if (Arrays.deepEquals(TEST4_RES, res.toArray())) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED_MNEM, Arrays.toString(TEST4_RES), res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }

        if (score == 4) {
            System.out.println(PASSED_ALL);
        } else if (score == 0) {
            System.out.println(NOT_IMPLEMENTED);
        } else {
            System.out.println(report);
        }
        System.out.println("*********************************************************\n");

    }

    private static void collectCoins2DTester() {

        System.out.println("**************** Collect Coins 2D Tester ****************");
        String report = "";
        int score = 0;

        int testBoard[][]={{1,9,8},{0,6,1},{2,8,3}};

        try {
            report += "[TEST #1] collectCoins2D(board, 0, 0) ...........";

            int res = Recursion.collectCoins2D(testBoard, 0,0);
            if (res == 27) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 27, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #2] collectCoins2D(board, 2, 0) ...........";

            int res = Recursion.collectCoins2D(testBoard, 2,0);
            if (res == 13) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 13, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #3] collectCoins2D(board, 1, 1) ...........";

            int res = Recursion.collectCoins2D(testBoard, 1,1);
            if (res == 17) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 17, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #4] collectCoins2D(board, 4, 2) ...........";

            int res = Recursion.collectCoins2D(testBoard, 4,2);
            if (res == -1) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, -1, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }

        if (score == 4) {
            System.out.println(PASSED_ALL);
        } else if (score == 0) {
            System.out.println(NOT_IMPLEMENTED);
        } else {
            System.out.println(report);
        }
        System.out.println("*********************************************************\n");

    }

    private static void collectCoins1DTester() {

        System.out.println("**************** Collect Coins 1D Tester ****************");
        String report = "";
        int score = 0;

        try {
            report += "[TEST #1] collectCoins1D([5, 3, 7, 10]) .........";
            int res = Recursion.collectCoins1D(new int[] {5, 3, 7, 10});
            if (res == 15) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 15, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #2] collectCoins1D([8, 15, 3, 7]) .........";
            int res = Recursion.collectCoins1D(new int[] {8, 15, 3, 7});
            if (res == 22) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 22, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #3] collectCoins1D([2, 1, 6, 3, 9]) .......";
            int res = Recursion.collectCoins1D(new int[] {2, 1, 6, 3, 9});
            if (res == 13) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 13, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }
        report += "\n";

        try {
            report += "[TEST #4] collectCoins1D([1, 1, 1, 1, 1, 1, 1]) .";
            int res = Recursion.collectCoins1D(new int[] {1, 1, 1, 1, 1, 1, 1});
            if (res == 4) {
                report += PASSED;
                score++;
            } else {
                report += String.format(FAILED, 4, res);
            }
        } catch (Exception e) {
            report += EXCEPTION;
        }

        if (score == 4) {
            System.out.println(PASSED_ALL);
        } else if (score == 0) {
            System.out.println(NOT_IMPLEMENTED);
        } else {
            System.out.println(report);
        }
        System.out.println("*********************************************************");
    }

    public static void main(String[] args) {
        humanPyramidWeightTester();
        generateMnemonicsTester();
        collectCoins2DTester();
        collectCoins1DTester();
    }

}