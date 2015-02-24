/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author umran
 */
public class CutTheSticks {

  static void cutSticks(int[] lengths) {
    Arrays.sort(lengths);
    
    int i = 0;
    while (i<lengths.length) {
      System.out.println(lengths.length-i);
      
      do {
        ++i;
      } while (i<lengths.length && lengths[i]==lengths[i-1]);
    }
    
  }

  public static void main(String[] args) {
    cutSticks(new int[]{5,4,4,2,2,8});
  }

}
