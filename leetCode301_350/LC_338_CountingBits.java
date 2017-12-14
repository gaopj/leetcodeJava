package leetCode301_350;

public class LC_338_CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++) {
        	res[i] = res[i>>1]+i%2;
        }
        return res;
    }
}
