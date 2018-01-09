package LC_351_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LC_399_EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<String,Map<String,Double>> map = new HashMap<>(); //领接表
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Set<String> set = new HashSet<>();
        int len = equations.length;
        for(int i=0;i<len;i++){ //建表
        	set.add(equations[i][0]);
        	set.add(equations[i][1]);
        	Map<String,Double> m;
            if (map.containsKey(equations[i][0])) {  
                m = map.get(equations[i][0]);  
            } else {  
                m = new HashMap<String, Double>();  
            }  
            m.put(equations[i][1], values[i]);  
            map.put(equations[i][0], m);  
      
            if (map.containsKey(equations[i][1])) {  
                m = map.get(equations[i][1]);  
            } else {  
                m = new HashMap<String, Double>();  
            }  
            m.put(equations[i][0], 1.0 / values[i]);  
            map.put(equations[i][1], m); 
        }
        double result[] =new double[queries.length];
        
        for (int i = 0; i < queries.length; i++) {  
        	  
            //初始化visited标记  
            Iterator<String> it = set.iterator();  
            Map<String, Boolean> visited = new HashMap<String, Boolean>();  
            while (it.hasNext()) {  
                visited.put(it.next(), false);  
            }  
      
            if (queries[i][0].equals(queries[i][1]) && set.contains(queries[i][0])) {  
                result[i] = 1;  
                continue;  
            }  
            //dfs  
            double res = dfs(queries[i][0], queries[i][1], 1, visited);  
            result[i] = res;  
        }  
        return result; 
    }
    public double dfs(String s, String t, double res, Map<String, Boolean> visited) {  
        if (map.containsKey(s) && !visited.get(s)) {  
            visited.put(s, true);  
            Map<String, Double> m = map.get(s);  
            if (m.containsKey(t)) {  
                return res * m.get(t);  
            } else {  
                Iterator<String> keys = m.keySet().iterator();  
                while (keys.hasNext()) {  
                    String key = keys.next();  
                    double state = dfs(key, t, res * m.get(key), visited);  
                    if (state != -1.0) {  
                        return state;  
                    }  
                }  
            }  
        } else {  
            return -1.0;  
        }  
        return -1.0;  
    } 
}
