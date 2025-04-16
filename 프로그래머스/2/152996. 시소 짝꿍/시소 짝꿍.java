import java.util.*;

class Solution {
    public long solution(int[] w) {
        long answer = 0;  
        
        Arrays.sort(w);
        HashMap<Double,Integer> map = new HashMap<>();
        
        for(int i = 0; i<w.length; i++){
            double[] targets = {w[i] *1.0, w[i] * 0.5, (w[i] * 2.0)/3.0 ,w[i] * 0.75};
            
            for(double t : targets){
                answer += map.getOrDefault(t,0);
            }
            
            map.merge(w[i] *1.0 , 1 ,Integer::sum);
        }
        
        return answer;
    }
}