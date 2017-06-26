/*
 * Name: Ying Pei
 * Login: cs8bsgx 
 * Date:  04/12/2017 Tue
 * File:  CaesarTester.java 
 * Tests Caesar.java using basic strings and rotation values. 
 * Name:    CaesarTester
 * Purpose: To test Caesar.java for correct output.
 * “In this section, we wrote testers for Caesar.java.
 * CaesarTester.java contains the code I wrote to test the provided functions for correctness.
 * Now, I learned to check for mistakes in code.
 */
public class CaesarTester {

  private static int testNum = 0;  // Keep track of which test we're running

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
      System.out.println("The correct answer is: " + expectedAnswer + "\n");
      return 1;
    } else {
      System.out.println("Test " + testNum + " Passed!\n");
      return 0;
    }
  }

  /*
   * Name:       main
   * Purpose:    To call methods in Caesar and test them
   * Parameters: String[] args - command line arguments that are unused
   * Return:     void
   */
  public static void main(String[] args) {

    /** The main method. THIS IS WHERE YOU SHOULD ADD MORE TESTS
     * FOR encrypt and decrypt methods AND ANY OTHER METHOD
     * THAT YOU CREATE. BE SURE TO TEST YOUR CODE THOROUGHLY
     **/

    //The Caesar Cipher Tests
    int failCases = 0;

    String message1 = "When in the course of human events it becomes necessary for one people to" + 
      " dissolve the political bands which have connected them with another and to"+
      " assume among the powers of the earth the separate and equal station to"+
      " which the laws of nature and of nature's God entitle them a decent respect"+
      " to the opinions of mankind requires that they should declare the causes"+
      " which impel them to the separation.";

    String encryptedAnswer = "Nyve ze kyv tflijv fw yldre vmvekj zk svtfdvj evtvjjrip " +
      "wfi fev gvfgcv kf uzjjfcmv kyv gfczkztrc sreuj nyzty yrmv tfeevtkvu kyvd nzky refkyvi" + 
      " reu kf rjjldv rdfex kyv gfnvij fw kyv vriky kyv jvgrirkv reu vhlrc jkrkzfe kf nyzty " + 
      "kyv crnj fw erkliv reu fw erkliv'j Xfu vekzkcv kyvd r uvtvek ivjgvtk kf kyv fgzezfej fw" + 
      " drebzeu ivhlzivj kyrk kyvp jyflcu uvtcriv kyv trljvj nyzty zdgvc kyvd kf kyv jvgrirkzfe.";

    System.out.println("***** PART A TESTS ******\n");

    //Test 1
    String encrypted1 = Caesar.encrypt(message1, 17);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");
  
    //Test 2
    String encrypted2 = "Byffi yhwlsjncih qilfx, byffi yhwlsjncih qilfx";
    String messageAnswer = "Hello encryption world, hello encryption world";
    String message2 = Caesar.decrypt(encrypted2, -58);
    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");

    System.out.println("\n***** PART B TESTS *******\n");		

    //Test 3
    encrypted1 = Caesar.encryptTwo(message1, 17);
    failCases += testCase(message1, encryptedAnswer, encrypted1, "encrypt");

    //Test 4
    message2 = Caesar.decryptTwo(encrypted2, -58);
    failCases += testCase(encrypted2, messageAnswer, message2, "decrypt");
    
  
    //Test for upper case
    String message3 = "MENU";
    String encryptedAnswer3 = "OGPW";
    String encrypted3 = Caesar.encryptTwo(message3, 2);

    failCases += testCase(message3, encryptedAnswer3, encrypted3, "encrypt");
    
    //Test for upper case
    String encrypted4 = "TLUB";
    String messageAnswer4 = "MENU";
    String message4 = Caesar.decryptTwo(encrypted4, 7);

    failCases += testCase(encrypted4, messageAnswer4, message4, "decrypt");
    
    //Test for inputing numbers//return the same
    String message5 = "1234";
    String encryptedAnswer5 = "1234";
    String encrypted5 = Caesar.encryptTwo(message5, 2);

    failCases += testCase(message5, encryptedAnswer5, encrypted5, "encrypt");
   
    //Test for inputing numbers
    String encrypted6 = "1234";
    String messageAnswer6 = "1234";
    String message6 = Caesar.decryptTwo(encrypted6, 7);

    failCases += testCase(encrypted6, messageAnswer6, message6, "decrypt");
   
    
    //Test for large values for rotation
    String encrypted8 = "BCDE";
    String messageAnswer8 = "ABCD";
    String message8 = Caesar.decryptTwo(encrypted8, 27);

    failCases += testCase(encrypted8, messageAnswer8, message8, "decrypt");
    
    //Test for negative values
    String message9 ="f";
    String encryptedAnswer9 = "e";
    String encrypted9 = Caesar.encryptTwo(message9, -1);

    failCases += testCase(message9, encryptedAnswer9, encrypted9, "encrypt");
    
    //Test for negative values
    String encrypted10 = "ldmb";
    String messageAnswer10 = "menc";
    String message10 = Caesar.decryptTwo(encrypted10, -1);

    failCases += testCase(encrypted10, messageAnswer10, message10, "decrypt");
    

    //Test for mixing symbol and Uppercase and number
    String encrypted14 = "&&A1";
    String messageAnswer14 = "&&B1";
    String message14 = Caesar.decryptTwo(encrypted14, -1);

    failCases += testCase(encrypted14, messageAnswer14, message14, "decrypt");


    //Messages that print whether tests were successful or not
    if (failCases == 0) {
      System.out.println("All Tests Passed!");
    } else {
      System.out.println("Number of Failed Test Cases : " + failCases);
    }
  }
}
