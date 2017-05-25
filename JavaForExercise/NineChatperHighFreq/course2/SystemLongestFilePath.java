package course2;

public class SystemLongestFilePath {
	
	//Needs to do again.
	public int lengthLongestPath(String input) {
        // Write your code here
        int result = 0;
        int[] path = new int[input.length() + 2];
        String[] st = input.split("\n");
        for (String line : st){
            String name = line.replaceAll("(\t)+", "");
            int depth = line.length() - name.length();
            if(name.contains("."))
                result = Math.max(result, path[depth] + name.length());
            else
                path[depth + 1] = path[depth] + name.length() + 1;
        }
        return result;
    }
}
