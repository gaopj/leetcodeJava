package leetCode201_250;

public class LC_231_PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isPowerOfTwo(int n) {
        return (n>0) &&((n &(n-1))==0);
    }
}
