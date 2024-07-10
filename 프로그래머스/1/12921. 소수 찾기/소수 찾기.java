import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] is_prime = new boolean[n+1];
        Arrays.fill(is_prime, true);
        is_prime[0] = false;
        is_prime[1] = false;
        
        int noPrime = 1;
        for(int i = 2; i < n+1; i++){
            if(is_prime[i]){
                for(int j = i*2; j < n+1; j += i){
                    if(is_prime[j]){
                        is_prime[j] = false;
                        noPrime++;
                    }
                }
            }
        }
        answer = n - noPrime;
        
        return answer;
    }
}