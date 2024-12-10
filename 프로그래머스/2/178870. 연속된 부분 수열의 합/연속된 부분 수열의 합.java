import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int diff1 = (a[1] - a[0]);
            int diff2 = (b[1] - b[0]);
            if (diff1 == diff2) {
                return Integer.compare(a[0], b[0]); // Sort by i if j-i is equal
            }
            return Integer.compare(diff1, diff2); // Sort by j-i
        });
        
        int start = 0;
        int end = 0;
        int sum = sequence[start];
        
        while(start <= end){
            
            if(sum > k){
                sum -= sequence[start];
                start++;
                // System.out.println("start:" + start + ", end:" + end + ", sum: "+ sum);
                
            }else if(sum < k){
                end++;
                if (end == sequence.length) break;
                sum += sequence[end];
                // System.out.println("start:" + start + ", end:" + end + ", sum: "+ sum);
                
            }else{
                // System.out.println(Arrays.toString(new int[] {start, end}));
                pq.add(new int[] {start, end});
                sum -= sequence[start];
                start++;
            }
        }
        
        return pq.poll();
    }
}