package course2;

public class SmallestRecEncloseBlackPix {
	
	
	//accepted 3.8.2017
	private final int ROW = -1;
	private final int COL = -2;
	
	public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if(image.length == 0 || image[0].length == 0){return 0;}
		int up, down, left, right;
		int start, end;
		//up
		start = 0;
		end = x;
		while(start+1<end){
			int mid = (end-start)/2+start;
			
			if(hasBlack(image,mid,ROW)){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(hasBlack(image,start,ROW)){
			up = start;
		}else{
			up = end;
		}
		//down
		
		start = x;
		end = image.length-1;
		
		while(start+1<end){
			int mid = (end-start)/2+start;
			
			if(hasBlack(image,mid,ROW)){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(hasBlack(image,end,ROW)){
			down = end;
		}else{
			down = start;
		}
		//left
		
		start = 0;
		end = y;
		while(start+1<end){
			int mid = (end-start)/2+start;
			
			if(hasBlack(image,mid,COL)){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(hasBlack(image,start,COL)){
			left = start;
		}else{
			left = end;
		}

		
		//right
		start = y;
		end = image[0].length-1;
		while(start+1<end){
			int mid = (end-start)/2+start;
			
			if(hasBlack(image,mid,COL)){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(hasBlack(image,end,COL)){
			right = end;
		}else{
			right = start;
		}

		return (right-left+1)*(down-up+1);
    }
	
	private boolean hasBlack(char[][] image, int rowCol, int mode){
		
		if(mode == ROW){
			for(int i=0;i<image[rowCol].length;i++){
				if(image[rowCol][i] == '1'){return true;}
			}
		}else{
			for(int i=0;i<image.length;i++){
				if(image[i][rowCol] == '1'){return true;}
			}
		}
		
		return false;
	}
}
