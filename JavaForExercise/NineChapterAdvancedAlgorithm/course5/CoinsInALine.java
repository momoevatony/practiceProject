package course5;

public class CoinsInALine {
	
	//Accetped 12.12.2016 855ms
	//Or return n%3!=0;
	public boolean firstWillWin(int n) {
        // write your code here
        if(n==0){return false;}
        if(n<=2){return true;}
        
        boolean[] map = new boolean[2];
        map[0] = true;
        map[1] = true;
        for(int i=3;i<=n;i++){
            map[i%2] = !(map[(i-1)%2] && map[(i-2)%2]);
        }
        
        return map[n%2];
    }

}
