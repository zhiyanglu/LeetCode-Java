/**
 * Find the total area covered by two rectilinear rectangles 
 * in a 2D plane.Each rectangle is defined by its bottom left 
 * corner and top right corner as shown in the figure.
 * @author Lu
 *
 */
public class RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RectangleArea().computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int area = (C - A) * (D - B) + (G - E) * (H - F);
    	
    	int cover = 0;
    	int left = Math.max(A, E);
    	int right = Math.min(C, G);
    	int top = Math.min(D, H);
    	int bottom = Math.max(B, F);
    	if(left < right && top > bottom){
    		cover = (right - left) * (top - bottom);
    	}
    	
    	return area - cover;
    }


}
