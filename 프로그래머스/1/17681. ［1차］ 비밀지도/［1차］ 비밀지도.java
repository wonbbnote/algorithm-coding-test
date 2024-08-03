class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 2진수로 변환
        for(int i = 0; i < n; i++){
            
            String binary1 = Integer.toBinaryString(arr1[i]); 
            String binary2 = Integer.toBinaryString(arr2[i]);
            
            int binary1Len = n - binary1.length();
            int binary2Len = n - binary2.length();
            
            if(binary1Len != 0){
                binary1 = "0".repeat(binary1Len) + binary1;
            }
            if(binary2Len != 0){
                binary2 = "0".repeat(binary2Len) + binary2;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(binary1.substring(j, j+1).equals("0") && binary2.substring(j, j+1).equals("0")){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
                
                
            }
            answer[i] = sb.toString();


        }
        
        
        
        return answer;
    }
}