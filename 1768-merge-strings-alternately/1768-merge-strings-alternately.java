class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int i1 = 0;
        int i2 = 0;

        String answer = "";

        while(i1 < w1.length || i2 < w2.length){
            if(i1 < w1.length){
                answer += w1[i1++];
            }

            if(i2 < w2.length){
                answer += w2[i2++];
            }
        }

        return answer;

    }
}