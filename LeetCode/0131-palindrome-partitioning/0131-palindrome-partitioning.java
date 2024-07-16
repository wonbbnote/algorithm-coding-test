class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> permutedCases = new ArrayList<>();
        int sLen = s.length();
        permutation(s, 0, sLen, new ArrayList<>(), permutedCases);
        // System.out.println("permutedCases: " +permutedCases);
        return permutedCases;
        
    }

    public boolean isPalindrome(String s){
        return s.equals((new StringBuilder(s)).reverse().toString());
    }

    public void permutation(String s, int start, int sLen, List<String> caseOne, List<List<String>> permutedCases){

        if(start == sLen){
            permutedCases.add(new ArrayList<>(caseOne));
        }

        for(int i = start; i < sLen; i++){
            String str = s.substring(start, i+1);
            if(isPalindrome(str)){
                caseOne.add(str);
                permutation(s, i + 1, sLen, caseOne, permutedCases);
                caseOne.remove(caseOne.size()-1);
            }
            
        }

    }
}