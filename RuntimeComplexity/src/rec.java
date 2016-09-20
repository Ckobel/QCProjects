public class rec {

	public static void main(String[] args) {
		
		System.out.println(index);
	}

	static int find(int[] arr, int val) {
		int atIndex = 0;
		if(arr.length <= 1){
			return 0;
		}
		
		int[] halfarr = new int[arr.length/2];
		
		if(val < arr[arr.length/2]){
			for(int i = 0; i < (arr.length/2)-1; i++){
				halfarr[i] = arr[i];
			}
			 return atIndex += find(halfarr,val);
		}
		
		else{
			for(int i = (arr.length/2)-1; i < arr.length-1; i++){
				halfarr[i] = arr[i];
			}
			return atIndex += find(halfarr,val);
		}
		
	}
}