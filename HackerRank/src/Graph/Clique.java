package Graph;

import java.util.Scanner;

public class Clique {
	
	public static int getTuranBound(double numberOfNodes, double maxCliqueSize){
		
		double numEdges = 0;
		
		double num1 = ((1 - (double)1/((double)maxCliqueSize)));
		double num2 = Math.pow(numberOfNodes, 2) / 2;
		
		numEdges = num1 * num2;
		
		return (int)numEdges;
		
	}
	
	public static int getMinCliqueSize(int numberOfNodes, int edges){
		
		int cliqueSize = 0;
		
		int lowerBound = 1;
		int upperBound = numberOfNodes ;
		
		int seed = (lowerBound + upperBound)/2;
	
		while(upperBound != lowerBound){
			
			seed = (lowerBound + upperBound)/2;
			int numEdges = getTuranBound(numberOfNodes, seed);
			
			if(numEdges == edges){
				return seed;
			}
			
			if(upperBound - lowerBound == 1){
				numEdges = getTuranBound(numberOfNodes, lowerBound);
				if(numEdges >= edges){
					return lowerBound;
				}else{
					return upperBound;
				}
			}
			
			
			if(numEdges > edges ){
				upperBound = seed;
			}else{
				lowerBound = seed ;
			}
			
			
		}
	
		System.out.println("ERROR");
		System.exit(-1);
		
		return cliqueSize;
		
		
	}
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1 ; i <= T ; i++){
			
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		
		System.out.println(Clique.getMinCliqueSize(nodes, edges));
		
		}
		
	}

}
