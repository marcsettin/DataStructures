import java.util.Scanner;
import java.io.*;

public class SpellChecker {

  public static void main(String [] args) {

    File f = new File("dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();
    
      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);      
      }
      System.out.println("Dicitonary loaded...");
     

      sk = new Scanner(System.in);
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word))
	      	System.out.println(word + " is correct.");
        else {
	  			System.out.println("Suggesting alternatives ...");
	  
	  			for (int i = 0; i < word.length(); i++) {
	    			StringBuffer sb = new StringBuffer(word); 
	    			for (char j = 'a'; j <= 'z'; j++) {
	      			sb.setCharAt(i, j);
	      			if (x.find(sb.toString()))
								System.out.println(sb.toString());
	    			}
      		}
        }
      }
 

    } catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 

  } 

}
