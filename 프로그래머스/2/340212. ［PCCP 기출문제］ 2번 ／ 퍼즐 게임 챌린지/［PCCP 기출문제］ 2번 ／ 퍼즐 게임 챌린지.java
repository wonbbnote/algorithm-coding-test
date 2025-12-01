class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int n = diffs.length;
        
        int left = 1;
        int right = 0;
        for(int d : diffs){
            right = Math.max(d, right);
        }

        
        while(left <= right){
            int mid = (left + right) / 2; // 숙련도
            
            long total = 0;
            int time_prev = 0;
            for(int i = 0; i < n; i++){
                int diff = diffs[i];
                int time = times[i];
                if(diff <= mid){
                    total += time;
                }else{
                    long nth = diff - mid;
                    total += nth * (time + time_prev) + time;
                }
                time_prev = times[i];   
            }
            
            if(total <= limit){
                answer = mid; 
                right = mid - 1;
            }else if(total > limit){
                left = mid + 1;
            }
        }
        
        return answer;
    }
}