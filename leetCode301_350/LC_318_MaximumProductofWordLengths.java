package leetCode301_350;

public class LC_318_MaximumProductofWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxProduct(String[] words) {
    	int len = words.length;
        int[] mark = new int[len];
        for(int i=0;i<len;i++) {
        	for(int j=0;j<words[i].length();j++) {
        		mark[i] |=1<<(words[i].charAt(j)-'a');
        	}
        }
        int max=0;
        for(int i=0;i<len;i++) {
        	for(int j=0;j<i;j++) {
        		if((mark[i]&mark[j])==0) {
        			max = Math.max(max, words[i].length()* words[j].length());
        		}
        	}
        }
        
        return max;
    }
}
