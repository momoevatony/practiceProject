package course1;

public class Strstr {
	
	//accepted 1.21.2017 
	public int strStr(String source, String target) {
        // write your code here
		if(source==null || source.length()<0 || target == null || target.length()<0 || source.length()<target.length()){return -1;}
        if( target.length()==0 ){return 0;}
		for(int i=0; i<source.length()-target.length()+1;i++){
			if(source.charAt(i)!=target.charAt(0)){continue;}
			for(int j=0;j<target.length();j++){
				if(j==target.length()-1 && source.charAt(i+j)==target.charAt(j)){return i;}
				if(source.charAt(i+j)!=target.charAt(j)){break;}
			}
		}
		return -1;
    }
}
