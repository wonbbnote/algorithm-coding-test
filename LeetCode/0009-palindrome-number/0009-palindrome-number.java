class Solution {
    public boolean isPalindrome(int x) {
        
        String xstr = x + "";

        int n = xstr.length() - 1;
        for(int i = 0; i < xstr.length() / 2; i++){
            if(xstr.charAt(i) != xstr.charAt(n)){
                return false;
            }
            n--;
        }

        return true;
    }
}