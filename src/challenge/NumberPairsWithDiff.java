/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;

import java.io.*;
import java.util.*;

/**
 *
 * @author umran
 */
public class NumberPairsWithDiff {

	/* List of numbers A */
	List<Long> sourceList;
	/* Numbers difference N */
	long	difference;
	
	/* Reads and populates the input values */
	void readInputValues() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/Users/umran/Downloads/test_cases_18rr7t3rr/input002.txt"))));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] list = br.readLine().split(" ");
		sourceList = new ArrayList<Long>();
		for (String num : list) {
			sourceList.add(Long.valueOf(num));
		}
		difference = Integer.valueOf(br.readLine());
  }
  
  public int getCountWithDiff() {
    Set<Long> sourceSet = new HashSet<>(sourceList);
    
    int count = 0;
    
    for (Long k:sourceSet) {
      if (sourceSet.contains(k+difference)) {
        ++count;
      }
    }
    
    return count;
  }

	public static void main(String args[]) throws Exception {
		NumberPairsWithDiff solution = new NumberPairsWithDiff();
    
    //  read input
		solution.readInputValues();

		// Use System.out.println with the result to run the tests
    System.out.println(solution.getCountWithDiff());
	}

}
