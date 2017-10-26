package midterm;
 
public class ReverseEvenIndices {
	static int[]input = {9, 4, 8, 7, 5, 1, 3};
	static int[]input1 = {6, 4, 1, 0, 3, 2};
	public static void main(String[] args){
		for(int i = 0; i < input.length; i++){
		System.out.print(reverseEvenIndices(input)[i]);
		}
	}
	
	private static int[] reverseEvenIndices(int[]input){
		if(input == null || input.length == 0){
			return input;
		}
		for(int i = 0; i < input.length/2; i = i+2){
			if(input.length % 2 == 0){
			swap(i,input.length - 2 - i,input);
			}else{
			swap(i,input.length - 1 - i,input);	
			}
		}
		return input;
	}

	private static void swap(int i, int j, int[] input) {
		  int temp = 0;
		  temp = input[i];
		  input[i] = input[j];
		  input[j] = temp; 
		 }
}
