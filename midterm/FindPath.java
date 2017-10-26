package midterm;

import java.util.ArrayList;

class Cell{ 
	     int x,y;

      Cell(int x, int y){ 
    	  
    	  this.x = x;

          this.y = y;

          }

      public String toString(){

       return "["+this.x +", "+this.y+ "]";

        }

             }
     public class FindPath {
    	 static int[][] maze = {
    			 {1, 0, 0, 0,1},
                 {1, 1, 1, 1,1},
                 {0, 1, 0, 0,1},
                 {1, 1, 0, 1,1},
    	 };
    	 static int m = maze.length;
		 static int n = maze[0].length;
		 static ArrayList<Cell> res = new ArrayList<Cell>();
    	 public static void main(String[] args) {
    		 System.out.println(findPath(maze));
    	 }
        
    	 
    	 public static ArrayList<Cell> findPath(int[][] maze){
   
    		 Cell cell = new Cell(0, 0);
    		 if (findPath(maze, 0, 0, cell) == false){
 	        	System.out.print("there is no result");
    		 }
 	            return res;
 	        }
 
    static boolean findPath(int maze[][], int x, int y, Cell cell){
    		 
    	        if (x == m - 1 && y == n - 1){
    	            cell.x = m - 1;
    	            cell.y = n - 1;
    	            res.add(new Cell(m - 1,n - 1));
    	            return true;
    	        }
    	        if (isVaild(maze, x, y) == true){
    	        	cell.x = x;
    	            cell.y = y;
    	            res.add(new Cell(x,y));
    	    
    	        if (findPath(maze, x + 1, y, cell)){
    	                return true;
    	        }
    	        if (findPath(maze, x, y + 1, cell)){
    	                return true;
    	        }
    	        res.remove(res.size()-1);//if the one which is added can not be extend, then the one should also be deleted 
    	        }
				return false;
    	 }
        	  static boolean isVaild(int maze[][], int x, int y){
      	       //index is reachable and the value is "1";
      return (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 1);
      	    }

        	  }
