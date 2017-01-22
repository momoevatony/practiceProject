package course4;

public class NutsAndBolts {
	
	//Got stuck at 49% test cases. Need TODO
	public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
		for(int i=0; i<nuts.length;i++){
			sort(bolts,nuts[i],compare);
			sort2(nuts,bolts[i],compare);
		}
    }
	private void sort(String[] array, String str, NBComparator compare){
		String pivot = "";
		for(int i=0; i<array.length;i++){
			if(compare.cmp(str,array[i]) ==0){
				pivot=array[i];
				array[i] = array[0];
				break;
			}
		}
		int left = 0;
		int right = array.length-1;
		while(left<right){
			while(left<right && compare.cmp(str,array[right])>=0){
				right--;
			}
			array[left] = array[right];
			while(left<right && compare.cmp(str,array[left])<=0){
				left++;
			}
			array[right] = array[left];
		}
		array[left] = pivot;
	}
	
	private void sort2(String[] array, String str, NBComparator compare){
		String pivot = "";
		for(int i=0; i<array.length;i++){
			if(compare.cmp(array[i],str) ==0){
				pivot=array[i];
				array[i] = array[0];
				break;
			}
		}
		int left = 0;
		int right = array.length-1;
		while(left<right){
			while(left<right && compare.cmp(array[right], str)<=0){
				right--;
			}
			array[left] = array[right];
			while(left<right && compare.cmp(array[left], str)>=0){
				left++;
			}
			array[right] = array[left];
		}
		array[left] = pivot;
	}
	
	public class NBComparator{
		public int cmp(String a, String b){
			return 0;
		}
	}
}
