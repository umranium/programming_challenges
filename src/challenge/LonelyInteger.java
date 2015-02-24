/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author umran
 */
public class LonelyInteger {

  
  static int lonelyInteger(int[] arr) {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>(arr.length);
    for (int i = 0; i < arr.length; ++i) {
      int v = arr[i];
      int count = 0;
      if (map.containsKey(v)) {
        count = map.get(v);
      }
      count++;
      map.put(v, count);
    }
    
    for (Map.Entry<Integer,Integer> e:map.entrySet()) {
      if (e.getValue()==1) {
        return e.getKey();
      }
    }    
    
    return -1;
  }
  
  public static void main(String[] args) {
    
    System.out.println(lonelyInteger(new int[]{1,1,2}));
  }
  
}
