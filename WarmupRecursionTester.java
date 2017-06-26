/**
 *  Name: Ying Pei
 *  Date: May 31, 2017
 *  File: WarmupRecursionTester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 8.
 *  WarmupRecursionTester is a java file 
 *  that test the three methods implemented in 
 *  WarmupRecursion.java
 *  
 */

/**
 * Name:    WarmupRecursionTester.java
 * Purpose: To test the three recursive functions in WarmupRecursion.java
 */

import java.util.ArrayList;
import java.util.Arrays;

public class WarmupRecursionTester {

    // Pretty-print messages
    private static final String PASSED = " Passed!";
    private static final String FAILED = " FAILED. Expected %s, got %s";
    private static final String FAILED_MNEM = " FAILED.\n\tExpected some String in %s\n\tGot %s";
    private static final String EXCEPTION = " Exception. Oh no! Something bad happened.";
    private static final String RESULT = "[RESULT] Passed %d / %d. Make sure to add more tests!";
    private static final String LINE = "***************************************************";

    // Binary String
    private static final int TEST1 = 1;
    private static final String TEST1_RES = "1";
    private static final int TEST2 = 10;
    private static final String TEST2_RES = "1010";
    private static final int TEST3 = 192;
    private static final String TEST3_RES = "11000000";
    private static final int TEST4 = 168;
    private static final String TEST4_RES = "10101000";

    // Mnemonics
    private static final String TEST5 = "2";
    private static final String[] TEST5_RES = {"A", "B", "C"};
    private static final String TEST6 = "43";
    private static final String[] TEST6_RES = {"GD", "GE", "GF",
            "HD", "HE", "HF",
            "ID", "IE", "IF"};
    private static final String TEST7 = "019";
    private static final String[] TEST7_RES = {"W", "X", "Y", "Z"};
    private static final String TEST8 = "324#";
    private static final String[] TEST8_RES = {"DAG", "DAH", "DAI",
            "DBG", "DBH", "DBI",
            "DCG", "DCH", "DCI",
            "EAG", "EAH", "EAI",
            "EBG", "EBH", "EBI",
            "ECG", "ECH", "ECI",
            "FAG", "FAH", "FAI",
            "FBG", "FBH", "FBI",
            "FCG", "FCH", "FCI"};

    // Subset Sum
    private static final ArrayList<Integer> ARRAY1 =
            new ArrayList<Integer>(Arrays.asList(2, -3, 4));
    private static final ArrayList<Integer> ARRAY2 =
            new ArrayList<Integer>(Arrays.asList(7, 1, -8));

    private static void binaryStringTester() {

        System.out.println("************** Print in Binary Tests **************");
        int score = 0;

        System.out.print("[TEST #1] binaryString(" + TEST1 + ") .................");
        try {
            String res = WarmupRecursion.binaryString(TEST1);
            if (res.equals(TEST1_RES)) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, TEST1_RES, res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #2] binaryString(" + TEST2 + ") ................");
        try {
            String res = WarmupRecursion.binaryString(TEST2);
            if (res.equals(TEST2_RES)) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, TEST2_RES, res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #3] binaryString(" + TEST3 + ") ...............");
        try {
            String res = WarmupRecursion.binaryString(TEST3);
            if (res.equals(TEST3_RES)) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, TEST3_RES, res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #4] binaryString(" + TEST4 + ") ...............");
        try {
            String res = WarmupRecursion.binaryString(TEST4);
            if (res.equals(TEST4_RES)) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, TEST4_RES, res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.println(LINE);
        System.out.println(String.format(RESULT, score, 4));
        System.out.println(LINE);
        System.out.println("");

    }

    /**
     * Tests generateRandomMnemonic implemented in WarmupRecursion.java
     */
    private static void randomMnemonicTester() {
        System.out.println("************** Random Mnemonic Tests **************");
        int score = 0;

        System.out.print("[TEST #1] generateRandomMnemonic(" + TEST5 + ") .......");
        try {
            String res = WarmupRecursion.generateRandomMnemonic(TEST5);
            if (Arrays.binarySearch(TEST5_RES, res) >= 0) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED_MNEM, Arrays.toString(TEST5_RES), res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #2] generateRandomMnemonic(" + TEST6 + ") ......");
        try {
            String res = WarmupRecursion.generateRandomMnemonic(TEST6);
            if (Arrays.binarySearch(TEST6_RES, res) >= 0) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED_MNEM, Arrays.toString(TEST6_RES), res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #3] generateRandomMnemonic(" + TEST7 + ") .....");
        try {
            String res = WarmupRecursion.generateRandomMnemonic(TEST7);
            if (Arrays.binarySearch(TEST7_RES, res) >= 0) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED_MNEM, Arrays.toString(TEST7_RES), res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #4] generateRandomMnemonic(" + TEST8 + ") ....");
        try {
            String res = WarmupRecursion.generateRandomMnemonic(TEST8);
            if (Arrays.binarySearch(TEST8_RES, res) >= 0) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED_MNEM, Arrays.toString(TEST8_RES), res));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.println(LINE);
        System.out.println(String.format(RESULT, score, 4));
        System.out.println(LINE);
        System.out.println("");

    }

    /**
     * Tests isSubSetSum implemented in WarmupRecursion.java
     */
    private static void isSubSetSumTester() {

        System.out.println("************** Subset Sum Tests **************");
        int score = 0;

        System.out.print("[TEST #1] isSubSetSum(" + ARRAY1 + ", " + 5 + ") ......");
        try {
            boolean res = WarmupRecursion.isSubSetSum(ARRAY1, 5);
            if (!res) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, false, true));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #2] isSubSetSum(" + ARRAY1 + ", " + 3 + ") ......");
        try {
            boolean res = WarmupRecursion.isSubSetSum(ARRAY1, 3);
            if (res) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, true, false));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #3] isSubSetSum(" + ARRAY2 + ", " + (-4) + ") .....");
        try {
            boolean res = WarmupRecursion.isSubSetSum(ARRAY2, -4);
            if (!res) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, false, true));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.print("[TEST #4] isSubSetSum(" + ARRAY2 + ", " + (-1) + ") .....");
        try {
            boolean res = WarmupRecursion.isSubSetSum(ARRAY2, -1);
            if (res) {
                System.out.println(PASSED);
                score++;
            } else {
                System.out.println(String.format(FAILED, true, false));
            }
        } catch (Exception e) {
            System.out.println(EXCEPTION);
        }

        System.out.println(LINE);
        System.out.println(String.format(RESULT, score, 4));
        System.out.println(LINE);
    }

    /**
     * Main method, calls testers
     * @param args not used
     */
    public static void main(String[] args) {
        binaryStringTester();
        randomMnemonicTester();
        isSubSetSumTester();
    }

}
