/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author umran
 */
public class NumberOfOccurrences {

  /* Target string A */
  String target;
  /* Source string B */
  String source;
  
  /* Target character histogram */
  int[] targetCharHist;

  /* Reads and populates the input values */
  private void readInputValues() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    target = br.readLine();
    source = br.readLine();
  }
  
  public void computeTargetHist() {
    //  Problem is not case sensitive, hence,
    //    convert chars to lowercase
    //  Iterating through the array might be faster than calling String.charAt(int)
    char[] targetChars = target.toLowerCase().toCharArray();
    
    targetCharHist = new int[1 << 16]; //assume unicode 16bit chars
    
    for (int i = 0; i < targetChars.length; ++i) {
      ++targetCharHist[targetChars[i]];
    }
  }
  
  public int getOccurrences() {
    //  Problem is not case sensitive, hence,
    //    convert chars to lowercase
    //  Iterating through the array might be faster than calling String.charAt(int)
    char[] sourceChars = source.toLowerCase().toCharArray();
    
    Set<Character> setOfSrcChars = new HashSet<Character>(sourceChars.length);
    for (char ch : sourceChars) {
      setOfSrcChars.add(ch);
    }
    
    int count = 0;
    for (Character ch : setOfSrcChars) {
      count += targetCharHist[ch];
    }
    
    return count;
  }

  public static void main(String args[]) throws Exception {
    NumberOfOccurrences solution = new NumberOfOccurrences();
    
    // read inputs
    solution.readInputValues();

    //  compute target histogram
    solution.computeTargetHist();
    
    //  compute and output occurrences
    System.out.println(solution.getOccurrences());
    // Use System.out.println with the result to run the tests
  }

}
