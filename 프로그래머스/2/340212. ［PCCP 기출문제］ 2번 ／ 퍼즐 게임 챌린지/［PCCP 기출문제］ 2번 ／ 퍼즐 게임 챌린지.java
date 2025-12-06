class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = 100000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            long totalTime = 0;
            int prevTime = 0;
            for(int i = 0; i < diffs.length; i++){
                int diff = diffs[i];
                int time = times[i];
                
                if(diff <= mid){
                    totalTime += time;
                }else{
                    totalTime += (diff - mid) * (time + prevTime);
                    totalTime += time;
                }
                prevTime = time;
            }
            
            // mid가 작으면, totalTime은 커진다.
            // mid가 크면, totalTime은 작아진다.
            if(limit < totalTime){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}