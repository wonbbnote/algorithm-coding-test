class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 101;
        for(int num: array){
            int difference = Math.abs(n - num);
            if(min > difference || (min == difference && answer > num)){
                min = difference;
                answer = num;
            }
        }
        
        return answer;
    }
}