package course8;

public class HashFunction {
	
	//Accepted 5.3.2017 2611ms
	public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long hashcode = 0;
        for (int i = 0; i < key.length; i++) {
            char curr = key[i];
            hashcode = (hashcode * 33 + (int)curr) % HASH_SIZE;
        }
        return (int)hashcode;
    }
}
