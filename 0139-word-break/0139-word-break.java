import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        int b = 0;
        Set<String> set = new HashSet<>();
        for(String w : wordDict){
            b = Math.max(w.length(), b);
            set.add(w);
        }

        for(int i = n - 1; i >= 0; i--){
            String str = "";

            for(int j = i; j < n && j - i + 1 <= b; j++){

                str += s.charAt(j);
                if(set.contains(str)){
                    dp[i] += dp[j+1];
                }
            }
        }

        System.out.println(dp[0]);

        if(dp[0] == 0){
            return false;
        }

        return true;
        
    }
}