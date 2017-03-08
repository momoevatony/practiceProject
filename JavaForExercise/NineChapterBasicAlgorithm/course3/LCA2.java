package course3;

import java.util.HashSet;
import java.util.Set;

public class LCA2 {
	
	//accepted 3.7.2017 1664ms
	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
		// Write your code here
		Set<ParentTreeNode> set = new HashSet<ParentTreeNode>();
		while(A!=null || B!=null){
			if(A!=null){
				if(set.contains(A)){return A;}
				set.add(A);
				A=A.parent;
			}
			if(B!=null){
				if(set.contains(B)){return B;}
				set.add(B);
				B=B.parent;
			}
		}
		return null;
	}
	
	class ParentTreeNode {
	     public ParentTreeNode parent, left, right;
	}
}
