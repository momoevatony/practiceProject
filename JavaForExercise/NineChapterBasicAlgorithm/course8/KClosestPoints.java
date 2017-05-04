package course8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
	
	//Accepted 5.3.2017 9561ms
	private Point global_origin = null;
    private Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare (Point a, Point b) {
            int diff = getDistance(b, global_origin) - getDistance(a, global_origin);
            if (diff == 0)
                diff = b.x - a.x;
            if (diff == 0)
                diff = b.y - a.y;
            return diff;
        }    
    };
    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
     
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        global_origin = origin;
        PriorityQueue<Point> heap = new PriorityQueue<Point>(k, PointComparator);
        for (Point point : points) {
            heap.add(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        Point[] ans = new Point[k];
        for (int i = 0; i < k; i++) {
            ans[k - i - 1] = heap.poll();
        }
        
        return ans;
    }

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}
