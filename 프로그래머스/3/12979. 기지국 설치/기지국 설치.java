import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        List<Integer> remain = new ArrayList<>();
        int start = 0;
        for(int t = 0; t < stations.length; t++){
            
            int space = stations[t] - w - 1 - start;
            int include = 2*w + 1;
            start = stations[t] + w;
            
            answer += space % include > 0 ? space / include + 1 : space / include;
        }
        
        if(stations[stations.length - 1] + w < n){
            int space = n - start;
            int include = 2*w + 1;
            answer += space % include > 0 ? space / include + 1 : space / include;
        }

        return answer;
    }
}