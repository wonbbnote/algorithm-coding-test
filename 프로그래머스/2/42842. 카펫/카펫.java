class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int width = 1;
        int height = 1;
        
        // brown = 2 * (width + height) - 4;
        // yellow + brown = width*height;
        
        int area = yellow + brown;
        
        while(true){
            height = (brown + 4)/2 - width;
            if(height * width == area && width >= height){
                answer = new int[] {width, height};
                break;
            }else{
                width++;
            }
        }
        
        
        return answer;
    }
}