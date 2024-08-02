class Solution {
    public long solution(int n) {
        long answer = 0;
        
        // D(n) = D(n-1) + D(n-2);
        long[] D = new long[n+1];
        answer = backtracking(n, D);
        
        return answer;
    }
    
    public long backtracking(int n, long[] D){
        if(n <= 2){
            D[n] = n;
        }
        if(D[n] == 0){
            D[n] = (backtracking(n-1, D) + backtracking(n-2, D)) % 1234567;
        }
        return D[n];
        
    }
}