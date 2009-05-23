package org.pr.clustering.soft;

import java.util.Calendar;
import java.util.Random;


/**
 * @author Ahmad
 */
public class MembershipMatrix {

	double[][] matrix;
	int n;
	int c;
	
	/**
	 * creates a MembershipMatrix and randomly initialize memberships
	 * 
	 * @param n number of patterns/observations
	 * @param c number of clusters/groups
	 */
	public MembershipMatrix(int n, int c) {
		this.n = n;
		this.c = c;
		
		matrix = new double[n][c];
		
		// we can make the random value to be 1 / k, 
		// giving equal memberships for all clusters << BAD IDEA, 
		// THIS WAY WE WILL GET OVERLAPPING CLUSTER CENTERS AT THE FIRST STEP
		
		// we need to really randomize this
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		for (int i = 0; i < n; i++) {
			double rowSum = 0;
			for (int j = 0; j < c; j++) {
				double randomMembership = rand.nextDouble();
				if (randomMembership + rowSum >= 1) {
					matrix[i][j] = 1- rowSum;
					break;
				} else {
					matrix[i][j] = randomMembership;
					rowSum += randomMembership;
				}
			}
		}
	}
	
	/**
	 * creates a MembershipMatrix using the specified matrix
	 */
	public MembershipMatrix(double[][] matrix) {
		this.matrix = matrix ;
	}
	
	public static void main(String[] args) { 
		MembershipMatrix mm = new MembershipMatrix(5, 3);
//		List<Integer> clusters = mm.getClusters();
//		System.out.println("");
//		
//		int[] patterns0 = mm.getPatternsForCluster(0);
//		int[] patterns1 = mm.getPatternsForCluster(1);
//		int[] patterns2 = mm.getPatternsForCluster(2);
		
		System.out.println();
	}
}
