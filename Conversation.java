/**
 * This creates a chatbot that communicates and responds to the user. 
 * This chatbot has a conversation that is a certain number of lines long, based on the user input to a query.
 * This chatbot either reflects back questions based on the user's response using mirror words 
 * or generates a randomized generic response.
 * @author Rachel Reinking
 * @version 15 February 2023
 */

 import java.util.Scanner;
import java.util.Random;

class Conversation {
  static String[] canned_responses = new String[] {"How interesting!", "Tell me more.", "I'm listening"}; 
  
  /**
   * Returns mirrors of recognized words in user response
   * @param s Word in user response
   * @return Mirror of word if the word is a recognized mirror word
   */
  public static String replaceMirrorWord(String s) {
    if (s.contains("I")) {
      return s.replace("I", "you");
    }
    if (s.contains("me")) {
      return s.replace("me", "you");
    }
    if (s.contains("am")) {
      return s.replace("am", "are");
    }
     if (s.contains("my")) {
      return s.replace("my", "your");
    }
    if (s.contains("your")) {
      return s.replace("your", "my");
    }
    if (s.contains("you")) {
      return s.replace("you", "I");
    }
    else {
      return s;
    }
  }

  /**
   * Checks if a user response contains any recognized mirror words
   * @param s User response
   * @return T/F: does this user response have any mirror words
   */  
  public static boolean hasMirrorWord(String s) {
    if (s.contains("I")) {
      return true;
    }
    if (s.contains("me")) {
      return true;
    }
    if (s.contains("am")) {
      return true;
    }
    if (s.contains("you")) {
      return true;
    }
    if (s.contains("my")) {
      return true;
    }
    if (s.contains("your")) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Demonstrates the usage and implementation of the chatbot 
   * @param arguments The command line arguments
   */
  public static void main(String[] arguments) {
    // You will start the conversation here.
    Scanner userInput = new Scanner(System.in);
    Random random = new Random();

    System.out.println("How many rounds?");
    
    int lines = userInput.nextInt();
    
    System.out.println("Welcome! What are you thinking about?");
    String [] user_transcript = new String[lines + 1];
    String [] bot_transcript = new String[lines + 1];
    for (int i = 0; i <= lines; i++) {
      String user_response = userInput.nextLine();
      user_transcript[i] = user_response;
      if (hasMirrorWord(user_response)) {
        String [] user_response_list = user_response.split(" ");
        for (int j = 0; j < user_response_list.length; j++) {
          user_response_list[j] = replaceMirrorWord(user_response_list[j]);
        }
        String bot_response = String.join(" ", user_response_list) + "?";
        bot_transcript[i] = bot_response;
        System.out.println(bot_response);
      }
      else {
        int ranindex = random.nextInt(3);
        String bot_response = canned_responses[ranindex];
        bot_transcript[i] = bot_response;
        if (i != 0) {
          System.out.println(bot_response);
        }
      }
    }
    System.out.println("Goodbye!");

    System.out.println();
    System.out.println("TRANSCRIPT:");
    for (int i = 0; i <= lines; i++) {
      System.out.println(user_transcript[i]);
      System.out.println(bot_transcript[i]);
    }

  userInput.close();
  
  }
}
