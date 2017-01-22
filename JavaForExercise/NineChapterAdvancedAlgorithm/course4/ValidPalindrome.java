package course4;

public class ValidPalindrome {
	
	//Accepted 12.17.2016 13415ms
	public boolean isPalindrome(String s) {
        // Write your code here
        if(s.length()<=1){return true;}
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j && (Character.toLowerCase(s.charAt(i)) > 'z' || Character.toLowerCase(s.charAt(i)) <'A') && !(Character.toLowerCase(s.charAt(i)) > '0' && Character.toLowerCase(s.charAt(i)) <'9')){
            	i++;
            }
            while(i<j && (Character.toLowerCase(s.charAt(j)) > 'z' || Character.toLowerCase(s.charAt(j)) <'A')  && !(Character.toLowerCase(s.charAt(j)) > '0' && Character.toLowerCase(s.charAt(j)) <'9')){
            	j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
            	return false;
            i++;
            j--;
        }
        return true;
    }
}
