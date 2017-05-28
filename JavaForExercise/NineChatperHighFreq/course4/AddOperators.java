package course4;

import java.util.ArrayList;
import java.util.List;

public class AddOperators {
	
	//accepted 5.27.2017
	public List<String> addOperators(String num, int target) {
        // Write your code here
        List<String> list = new ArrayList<>();
        dfs(list, "", num, 0, target, 0, 0);
        
        return list;
    }
    
    private void dfs (List<String> list, String path, String num, int index, int target, long eval, long lastFact) {
        if (index == num.length()) {
            if (eval == target) {
                list.add(path);
            }
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(list, path + curr, num, i + 1, target, curr, curr);
            } else {
                dfs(list, path + "+" + curr, num, i + 1, target, eval + curr, curr);
                dfs(list, path + "-" + curr, num, i + 1, target, eval - curr, -curr);
                dfs(list, path + "*" + curr, num, i + 1, target, eval - lastFact + lastFact * curr, lastFact * curr);
            }
            
        }
        
    }
}
