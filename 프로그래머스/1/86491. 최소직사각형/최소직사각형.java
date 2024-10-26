class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int minWidth = 0;
        int minHeight = 0;
        
        for(int i = 0; i < sizes.length; i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            if(width < height){
                width = sizes[i][1];
                height = sizes[i][0];
            }
            minWidth = Math.max(minWidth, width);
            minHeight = Math.max(minHeight, height);
        }
        
        return minWidth * minHeight;
    }
    
}