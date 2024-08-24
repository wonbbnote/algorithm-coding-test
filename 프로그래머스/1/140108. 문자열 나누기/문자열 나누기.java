class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0;
        
        while(idx < s.length()){
            
            String x = s.substring(idx, idx+1);
            int xNum = 1;
            int yNum = 0;
            idx++;   
            
            while(xNum != yNum){
                
                if(idx >= s.length()){
                    break;
                }
                
                String next = s.substring(idx, idx+1);
                if(next.equals(x)){
                    xNum++;
                }else{
                    yNum++;
                }
                idx++;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}