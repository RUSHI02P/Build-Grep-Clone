import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    if (args.length != 2 || !args[0].equals("-E")) {
      System.out.println("Usage: ./your_program.sh -E <pattern>");
      System.exit(1);
    }

    String pattern = args[1];  
    Scanner scanner = new Scanner(System.in);
    String inputLine = scanner.nextLine();

    // You can use print statements as follows for debugging, they'll be visible when running tests.
    System.err.println("Logs from your program will appear here!");

    // Uncomment this block to pass the first stage
    
    if (matchPattern(inputLine, pattern)) {
        System.exit(0);
    } else {
        System.exit(1);
    }
  }

  public static boolean matchPattern(String inputLine, String pattern) {
    // Character Array presentation of String 
    char[] sequence = inputLine.toCharArray();
    if (pattern.length() == 1) {
      return inputLine.contains(pattern);
    } 
    else if(pattern.contains("\\d")){
      // For any character in the array if it's between [0 to 9] ---> \d matches [0 to 9] ---> return true
      for(char ch : sequence){
        // Representation through ASCII Coding Standard
        if(ch >=48 && ch <= 57) return true;
      }
      return false;
    }
    else if(pattern.contains("\\w")){
      // For any character in the array if it's between [0 to 9, A - Z, a - z, _ ] ---> \w matches [0 to 9, A - Z, a - z, _ ] ---> return true
      for(char ch : sequence){
        // Representation via ASCII Coding Standard
        if((ch >=65 && ch <=90) || (ch >= 97 && ch <=122) || (ch >=48 && ch <= 57) || ch == 95 ) return true;
      }
      return false;
    }
    else {
      throw new RuntimeException("Unhandled pattern: " + pattern);
    }
  }
}
