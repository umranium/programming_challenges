/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author umran
 */
public class Pangrams {

  static int isPangram(String n) {
    char[] ch = n.toLowerCase().toCharArray();
    
    Map<Integer,Integer> b = new HashMap<Integer,Integer>(ch.length);
    
    for (int i = 0; i < ch.length; ++i) {
      int number = ch[i];
      
      int count = 0;
      if (b.containsKey(number)) {
        count = b.get(number);
      }
      
      ++count;
      
      b.put(number, count);
    }
    
    for (char c='a'; c<='z'; ++c) {
      if (!b.containsKey((int)c)){
        return 0;
      }
    }
    
    return 1;
  }

  public static void main(String[] args) {
    System.out.println(isPangram("We promptly judged antique ivory buckles for the prize"));
  }

}
