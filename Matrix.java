package assignment5;

import java.util.ArrayList;
import java.util.List;

public class Matrix{
	static int[][] mat = {{1,2,3},
			              {4,5,6},
			              {7,8,9}};
	 public static void main(String[] args) {
		 System.out.println(spiralOrder(mat));
	 }
	 
	 public static List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> list = new ArrayList<Integer>();
	        if(matrix == null) return list;
	         if (matrix.length == 0)  
	        return list; 
	    
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        int layer = (int)Math.ceil((Math.min(rows,cols))/2.0);
	        for(int i = 0 ; i<layer;i++){
	           
	            for(int j = i ; j<cols - i;j++)
	                list.add(matrix[i][j]);
	            
	            for(int k = i+1; k<rows - i ; k++)
	                list.add(matrix[k][cols -i- 1]);
	            
	    
	            for(int j = cols - i - 2; (j>=i)&&(rows-i - 1 != i) ; j--)
	                list.add(matrix[rows-i - 1][j]);
	            
	          
	            for(int k = rows - i - 2; (k>i)&&(cols -i - 1 != i) ; k--)
	                list.add(matrix[k][i]);
	            
	    }
	        return list;
	}
	 }

