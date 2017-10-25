package leetCode201_250;

public class LC_223_RectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	   public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {  
	        int area1 = (C-A) * (D-B);  
	        int area2 = (G-E) * (H-F);  
	          
	        int overlapRegion = overlap(A, B, C, D, E, F, G, H);  
	        return area1 + area2 - overlapRegion;  
	    }
	   
	 int  overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
		int res = 0;
		int x1 = Math.max(A, E);
		int y1 = Math.max(B, F);
		int x2 = Math.min(C, G);
		int y2 = Math.min(D, H);
		if(x2<=x1||y2<=y1) return 0;
		else return (x2-x1)*(y2-y1);
	 }
}
