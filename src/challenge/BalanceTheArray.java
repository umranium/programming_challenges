/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

/**
 *
 * @author umran
 */
public class BalanceTheArray {

  static int sumBalance(int[] arr) {

    int[] cumSum = new int[arr.length+1];
    
    for (int i = 0; i < arr.length; ++i) {
      cumSum[i+1] = cumSum[i] + arr[i];
    }
    
    for (int i = 1; i < arr.length-1; ++i) {
      int sumLeft = cumSum[i];
      int sumRight = cumSum[arr.length] - cumSum[i+1];
      
//      System.out.println(">> "+arr[i]+": "+sumLeft+" "+sumRight);
      if (sumLeft==sumRight)
        return 1;
    }
    
    return 0;
  }

  public static void main(String[] args) {
    sumBalance(new int[]{1,2,3,4,5,6});
  }

}
