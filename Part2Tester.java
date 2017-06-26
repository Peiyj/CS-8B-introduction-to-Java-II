/*
 * Name: Ying Pei
 * Login: cs8bsgx 
 * Date:  04/12/2017 Tue
 * File:  Part2Tester.java 
 * In this section, we wrote testers for code we were not able to read. Rather, the testers were based on 
 * the documentation.
 * Part2Tester.java contains the code in order to test the provided functions for correctness.
 * I learned to check for mistakes in the file
*/
public class Part2Tester {

  private static int testNum = 0;

  /**
   * Check the test case to see if it's correct
   * @param message The message to encrypt or decrypt
   * @param expectedAnswer The answer expected
   * @param actualAnswer The actual answer produced
   * @param enc_or_dec A string specifying what function was tested.
   * @return 1 if the test failed, and 0 otherwise.
   */
  public static int testCase(String message, String expectedAnswer, 
      String actualAnswer, String enc_or_dec) {
    testNum++;
    if (!expectedAnswer.equals(actualAnswer)) {
      System.out.println("Test " + testNum + " Failed (" + 
          enc_or_dec + ")");
      System.out.println("Given message to " + enc_or_dec + " is: " 
          + message);
      System.out.println("Your Answer is: " + actualAnswer);
      System.out.println("The correct answer is: " + expectedAnswer);
      return 1;
    } else {
      System.out.println("Test " + testNum + " Passed!\n");
      return 0;
    }
  }

  /**
   * The main method to test the Caesar class.
   * @param args Unused
   */
  public static void main (String[] args) {

    /** The main method. THIS IS WHERE YOU SHOULD ADD TESTS TO FIND
     * THE ERRORS IN CeasarWithBugs.  We have a few tests, but they 
     * do not expose the errors.
     **/

    //The Caesar Cipher With Bugs Tests
    int failCases = 0;

    //Test 1
    String message1 = "menu";
    String encryptedAnswer = "ogpw";
    String encrypted1 = CaesarWithBugs.encrypt(message1, 2);

    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");    	

    //Test 2
    String encrypted2 = "tlub";
    String messageAnswer = "menu";
    String message2 = CaesarWithBugs.decrypt(encrypted2, 7);

    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");
    
    //Test for upper case
    String message3 = "MENU";
    String encryptedAnswer3 = "OGPW";
    String encrypted3 = CaesarWithBugs.encrypt(message3, 2);

    failCases += testCase(message3, encryptedAnswer3, encrypted3, "encrypt");
    
    String encrypted4 = "TLUB";
    String messageAnswer4 = "MENU";
    String message4 = CaesarWithBugs.decrypt(encrypted4, 7);

    failCases += testCase(encrypted4, messageAnswer4, message4, "decrypt");

   
    String message5 = "1234";
    String encryptedAnswer5 = "1234";
    String encrypted5 = CaesarWithBugs.encrypt(message5, 2);

    failCases += testCase(message5, encryptedAnswer5, encrypted5, "encrypt");
   
    //Test for inputing numbers
    String encrypted6 = "1234";
    String messageAnswer6 = "1234";
    String message6 = CaesarWithBugs.decrypt(encrypted6, 7);

    failCases += testCase(encrypted6, messageAnswer6, message6, "decrypt");
   
    //Test for large values for rotation
    String message7 ="menu";
    String encryptedAnswer7 = "ogpw";
    String encrypted7 = CaesarWithBugs.encrypt(message6, 28);

    failCases += testCase(message7, encryptedAnswer7, encrypted7, "encrypt");
    
    String encrypted8 = "TLUB";
    String messageAnswer8 = "MENU";
    String message8 = CaesarWithBugs.decrypt(encrypted8, 33);

    failCases += testCase(encrypted8, messageAnswer8, message8, "decrypt");
    
    //Test for negative values
    String message9 ="menu";
    String encryptedAnswer9 = "ldmt";
    String encrypted9 = CaesarWithBugs.encrypt(message9, -1);

    failCases += testCase(message9, encryptedAnswer9, encrypted9, "encrypt");
    
    String encrypted10 = "ldmt";
    String messageAnswer10 = "menu";
    String message10 = CaesarWithBugs.decrypt(encrypted10, -1);

    failCases += testCase(encrypted10, messageAnswer10, message10, "decrypt");
    
    //Test for inputing symbols;
    String message11 ="&^%$";
    String encryptedAnswer11 = "&^%$";
    String encrypted11 = CaesarWithBugs.encrypt(message9, 1);

    failCases += testCase(message11, encryptedAnswer11, encrypted11, "encrypt");
    
    String encrypted12 = "&^%$";
    String messageAnswer12 = "&^%$";
    String message12 = CaesarWithBugs.decrypt(encrypted10, -1);

    failCases += testCase(encrypted12, messageAnswer12, message12, "decrypt");
     
    //Test for mixing symbol and Uppercase and number
    String message13 ="&^B$";
    String encryptedAnswer13 = "&^A$";
    String encrypted13 = CaesarWithBugs.encrypt(message9, 1);

    failCases += testCase(message13, encryptedAnswer13, encrypted13, "encrypt");
    
    String encrypted14 = "&^A1";
    String messageAnswer14 = "&^A1";
    String message14 = CaesarWithBugs.decrypt(encrypted14, -1);

    failCases += testCase(encrypted14, messageAnswer14, message14, "decrypt");
    
    
    //Test for space
    String encrypted15 = "   ";
    String messageAnswer15 = "   ";
    String message15 = CaesarWithBugs.decrypt(encrypted14, -1);

    failCases += testCase(encrypted15, messageAnswer15, message15, "decrypt");
    
    String message16 ="    ";
    String encryptedAnswer16 = "    ";
    String encrypted16 = CaesarWithBugs.encrypt(message16, 12);

    failCases += testCase(message16, encryptedAnswer16, encrypted16, "encrypt");
    
    //Test for null with negative rotation
    String encrypted17 = "";
    String messageAnswer17 = "";
    String message17 = CaesarWithBugs.decrypt(encrypted17, -4);

    failCases += testCase(encrypted17, messageAnswer17, message17, "decrypt");
  
    
    //Test when rotation is zero
    
    String message18 ="abcd";
    String encryptedAnswer18 = "abcd";
    String encrypted18 = CaesarWithBugs.encrypt(message18, 0);

    failCases += testCase(message18, encryptedAnswer18, encrypted18, "encrypt");

    

    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("Number of Failed Test Cases : " + failCases);
    }
  }
}
