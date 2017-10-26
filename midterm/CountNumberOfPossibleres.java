package midterm;

public class CountNumberOfPossibleres { 
	public static void main(String[] args) {  
   System.out.println(countNumberOfPossibleres(6, 3, 8));     
 }  
 
// maxValue is the max value of the face of the dice, and nums is how many dices there are  
public static int countNumberOfPossibleres(int maxValue, int nums, int sum){  
    if(sum < 1){     // boundaries
        return 0;  
    }  
    if(nums == 1){ // boundaries  
        return sum <= maxValue ? 1 : 0;  
    }  
      
    int res = 0;  
    for(int i=1; i<=maxValue; i++){  
        res += countNumberOfPossibleres(maxValue, nums-1, sum-i);  
    }  
    return res;  
}  
  
} 