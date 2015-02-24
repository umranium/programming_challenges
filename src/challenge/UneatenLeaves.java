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
public class UneatenLeaves {
  
  private static long gcd(long a, long b) {
    while (b > 0) {
      long temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }

  private static long gcd(long[] input) {
    long result = input[0];
    for (int i = 1; i < input.length; i++) {
      result = gcd(result, input[i]);
    }
    return result;
  }

  private static long lcm(long a, long b) {
    return a * (b / gcd(a, b));
  }

  private static long lcm(long[] input) {
    long result = input[0];
    for (int i = 1; i < input.length; i++) {
      result = lcm(result, input[i]);
    }
    return result;
  }

  private static long count(long[] set, long N) {
    long l = lcm(set);
    return N/l;
  }
  
  public interface SetFactory<E> {
      Set<E> createSet();
  }

  public static <E> List<Set<E>> computePowerSet(Set<E> set, SetFactory<E> setFactory) {
      List<Set<E>> list = new ArrayList<>();

      if (set.isEmpty()) {
          Set<E> emptySet = setFactory.createSet();
          list.add(emptySet);
          return list;
      }

      E first = set.iterator().next();

      set.remove(first);

      List<Set<E>> subsets = computePowerSet(set, setFactory);

      for (Set<E> subset : subsets) {
          Set<E> copy = setFactory.createSet();
          copy.addAll(subset);
          copy.add(first);

          list.add(subset);
          list.add(copy);
      }

      set.add(first);

      return list;
  }
      
  static int countUneatenLeaves(long N, final int[] A) {
    long totalEaten = 0;
    
    Set<Long> set = new HashSet<>();
    for (int a:A) {
      set.add((long)a);
    }
    
    List<Set<Long>> powSet = computePowerSet(set, new SetFactory<Long>() {

      @Override
      public Set<Long> createSet() {
        return new HashSet<>(A.length);
      }
    });
    
//    System.out.println("Set: "+set);
//    System.out.println("Power Set: "+powSet);
    
    for (int s = 1; s <= A.length; ++s) {
//      System.out.println("Sub set of "+s);
      
      long[] vArr = new long[s];
      for (Set<Long> v:powSet) {
        if (v.size()!=s) {
          continue;
        }
        
//        System.out.println("  set: "+v);
        
        int i = 0;
        for (Long x:v) {
          vArr[i] = x;
          ++i;
        }
        
        long cnt = count(vArr,N);
        
//        System.out.println("     cnt="+cnt);
        
        if (s%2==0) {
          totalEaten -= cnt;
        } else {
          totalEaten += cnt;
        }
      }
    }
    
//    System.out.println(totalEaten);
    
    return (int)(N - totalEaten);
  }
  
  public static void main(String[] args) {
    System.out.println(countUneatenLeaves(1000000000, new int[]{100001,100003}));
  }
  
  public static void xmain(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
    int res;
    int _N;
    _N = Integer.parseInt(in.nextLine());

    int _A_size = Integer.parseInt(in.nextLine());
    int[] _A = new int[_A_size];
    int _A_item;
    for (int _A_i = 0; _A_i < _A_size; _A_i++) {
      _A_item = Integer.parseInt(in.nextLine());
      _A[_A_i] = _A_item;
    }

    res = countUneatenLeaves(_N, _A);
    bw.write(String.valueOf(res));
    bw.newLine();

    bw.close();
  }
}
