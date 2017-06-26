// Keep these two lines.  They are what tell Java to include the
// classes you need for working with files.
// You might get warnings about them at first.  That's OK, just
// ignore the warnings.  They should go away as you complete your code.
import java.io.*;
import java.util.*;

/*
 * Name: Ying Pei
 * Login: cs8bsgx 
 * Date:  04/12/2017 Tue
 * File: Caesar.java 
 * Purpose: To encrypt and decrypt String of characters.
 * In this section, we made five methods to encrypt and decrypt a string of characters.
 * LetterOperation is a method that allows us to right or left shift character.
 * Encrypt and Decrypt methods allow us to encrypt and decrypt the sting of characters
 * EncryptTwo and DecryptTwo uses StringBuilder class to do the same functions. 
 * Now, I learned how string and stingbuilder classes work.
 */
public class Caesar 
{

/*this method uses String class to create a copy of String s
 *Then concat the encrypted character to the String copy using letter operation
 * It is then returned a copy of the string
 */
  public static String encrypt(String s, int rotation) 
  {
   String copy = "";
   for(int i = 0; i < s.length(); i++)
   {
	  char encryptL = letterOperation(s.charAt(i), rotation);
	  
	  copy = copy + encryptL;	  
   }
   return copy;    
  }

  /*this method uses String class to create a copy of String s
   * Then concat the decrypted character to the String copy using letter operation
   * It is then returned a copy of the string
   */
  public static String decrypt(String s, int rotation) 
  {

	  String copy = "";
	   for(int i = 0; i < s.length(); i++)
	   {
		  char encryptL = letterOperation(s.charAt(i), -rotation);
		  
		  copy = copy + encryptL;	  
	   }
	   return copy;    
  }

  /*this method uses String class to create a copy of String s
   * Then concat the decrypted character to the String copy using letter operation
   * It is then returned a copy of the string
   */
  private static char letterOperation(char a, int rotation) 
  {
	  //if the value is non-alphabet, just return a
	  int newRotate = rotation % 26;
	  char b = 0;
	  if((a > 123 || a < 65) 
	   ||(a > 90 && a < 97))
	  {
		  return a;
	  }
	  /*if the character is between 65 and 90 and between 97 and 122
	   * Then do the letterOperation
	   * If not, return the character a. 
	   */
	  if(((a < 91) && (a > 64))
				 ||((a < 123) && (a > 96)))	 
	  {
		//set up each of the if statements
		//if the rotation is negative, then we left shift the character
		  if(newRotate < 0)
		  {
			  if ( (int) a >= 65 - newRotate && (int) a < 91)
			  {
				  b = (char) ((int) a + newRotate); 
			  }
			  if ( (int) a < 65 - newRotate)
			  {
				  b = (char) ((int) a + (26 + newRotate));
			  }
			  if ( (int) a >= 97 - newRotate)
			  {
				  b = (char) ((int) a + newRotate); 
			  }
			  if ( (int) a < 97 - newRotate && (int) a > 90)
			  {
				  b = (char) ((int) a + (26 + newRotate));
			  }
			  return b;
		  }
	     //if the rotation is positive, then right shift the character
		  else if(newRotate > 0)
		  {
			  if ( (int) a < 90 - newRotate && (int) a > 64)
			  {
				  b = (char) ((int) a + newRotate); 
			  }
			  if ( (int) a >= 90 - newRotate && (int) a < 91)
			  {
				  b = (char) ((int) a - (26 - newRotate));
			  }
			  if ( (int) a <= 123 - newRotate&& (int) a > 96)
			  {
				  b = (char) ((int) a + newRotate); 
			  }
			  if ( (int) a >= 123 - newRotate)
			  {
				  b = (char) ((int) a - (26 - newRotate));
			  }
			  return b;
		  }
	 }
	  b = a;
	  return b;
 }

  public static String encryptTwo(String s, int rotation) 
  {
    // TODO: Complete this method
    // letters are between 65 and 90 (Upper Case) and 97 and 122 (Lower Case)
	StringBuilder copy = new StringBuilder();
	for(int i = 0; i < s.length(); i++)
	{
		char encrypt = letterOperation(s.charAt(i), rotation);
		copy.append(encrypt);
	}
	return copy.toString();
  }

  public static String decryptTwo(String s, int rotation) 
  {
	  /*this method uses StringBuilder class to create an instance of a String s
	   * Then append the decrypted character to the StringBuilder copy
	   * Then convert StringBuilder copy to String s
	   * Then return this String.
	   */
	  StringBuilder copy = new StringBuilder();
		for(int i = 0; i < s.length(); i++)
		{
			char encrypt = letterOperation(s.charAt(i), -rotation);
			copy.append(encrypt);
		}
		return copy.toString();
  }

 
}
