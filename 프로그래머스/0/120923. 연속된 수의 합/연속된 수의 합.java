class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int center_num = total / num;
        int center_idx;
        int res_start;
        
        if(num % 2 == 0){ // 짝수개
            center_idx = num / 2 - 1;
            res_start = center_num - center_idx;
            
        }else{
            center_idx = num / 2;
            res_start = center_num - center_idx;
        }
        
        for(int i = 0 ; i < num; i++){
                answer[i] = res_start;
                res_start++;
            }
    
        return answer;
    }
}