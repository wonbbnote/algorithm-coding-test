class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int result_numer = numer1*denom2 + numer2*denom1;
        int result_denom = denom1 * denom2;
        
        int big = result_denom >= result_numer ? result_denom : result_numer;
        int small = result_denom < result_numer ? result_denom : result_numer;
        
        while(true){
            if(big % small == 0){
                break;
            }else{
                int remain = big % small;
                big = small;
                small = remain;
                
            }
        }
        
        answer[0] = result_numer / small;
        answer[1] = result_denom / small;
        
        return answer;
    }
}