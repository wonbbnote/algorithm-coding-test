class Solution {
    public int solution(int n) {
        int answer = n+1;
        int condition2 = Integer.bitCount(n);
        
        while(true){
            if(condition2 == Integer.bitCount(answer)){
                break;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}