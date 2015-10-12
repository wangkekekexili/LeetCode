import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	
	private String d2s(double d) {
		return d2s(d, 5);
	}
	
	private String d2s(double d, int precision) {
		return String.format("%."+Integer.toString(precision)+"f", d);
	}
	
    public int maxPoints(Point[] points) {
    	if (points == null || points.length == 0) {
    		return 0;
    	}
    	if (points.length == 1) {
    		return 1;
    	}
    	int max = 0;
    	for (int base = 0; base < points.length - 1; base++) {
    		int duplicates = 0;
    		Map<String, Integer> slopeToCount = new HashMap<>();
    		for (int ref = base + 1; ref < points.length; ref++) {
    			Point basePoint = points[base];
    			Point refPoint = points[ref];
    			if (basePoint.x == refPoint.x && basePoint.y == refPoint.y) {
    				duplicates++;
    			} else if (basePoint.x == refPoint.x) {
    				Integer oldCount = slopeToCount.get(d2s(Double.MAX_VALUE));
    				if (oldCount == null) {
    					oldCount = 0;
    				}
    				slopeToCount.put(d2s(Double.MAX_VALUE), oldCount+1);
    			} else {
    				double slope = (0.0 + refPoint.y - basePoint.y) / 
    						(refPoint.x - basePoint.x);
    				slope += 0.0;
    				Integer oldCount = slopeToCount.get(d2s(slope));
    				if (oldCount == null) {
    					oldCount = 0;
    				}
    				slopeToCount.put(d2s(slope), oldCount+1);
    			}
    		}
    		int currentMax = 0;
    		for (Integer i : slopeToCount.values()) {
    			if (i > currentMax) {
    				currentMax = i;
    			}
    		}
    		if (currentMax + 1 + duplicates > max) {
    			max = currentMax + 1 + duplicates;
    		}
    	}
    	return max;
    }
}
