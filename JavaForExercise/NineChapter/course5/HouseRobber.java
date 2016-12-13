package course5;

public class HouseRobber {
	
	//Accepted 12.12.2016 4351ms
	public long houseRobber(int[] A) {
        // write your code here
		if(A.length==0){return 0;}
		long[] map = new long[2];
		map[0] = 0;
		map[1] = A[0];
		for(int i=2;i<=A.length;i++){
			map[i%2] = Math.max(map[(i-2)%2]+A[i-1], map[(i-1)%2]);
		}
		return map[A.length%2];
    }
}
