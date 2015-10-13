
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, 
    		int E, int F, int G, int H) {
    	int targetBottomLeftX = A>E?A:E;
    	int targetBottomLeftY = B>F?B:F;
    	int targetTopRightX = C>G?G:C;
    	int targetTopRightY = D>H?H:D;
    	int targetArea = 0;
		if (targetTopRightX > targetBottomLeftX &&
				targetTopRightY > targetBottomLeftY) {
			targetArea = (targetTopRightX - targetBottomLeftX) *
					(targetTopRightY - targetBottomLeftY);
		} 
		
    }
}
