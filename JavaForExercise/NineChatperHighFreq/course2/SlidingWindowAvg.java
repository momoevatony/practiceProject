package course2;

public class SlidingWindowAvg {
	
	//accepted 5.7.2017 3429ms
	public class MovingAverage {
	    
	    double avg;
	    double sum;
	    int[] data;
	    int index;
	    int size;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        this.avg = 0.0;
	        this.sum = 0;
	        this.index = 0;
	        this.size = size;
	        this.data = new int[size];
	    }
	    
	    public double next(int val) {
	        // Write your code here
	        if (index + 1 >= size) {
	            sum -= data[index % size];
	        }
	        data [index % size] = val;
	        sum += val;
	        index++;
	        return index >= size ? (sum / size) : (sum / index);
	    }
	}
}
