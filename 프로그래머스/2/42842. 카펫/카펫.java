class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int num = (brown+4) / 2;
        for(int i = 1; i < num; i++){
            int col = i;
            int row = num - i;
            if(row * col - yellow == brown){
                return new int[] {row, col};
            }
        }
        
        return answer;
    }
}