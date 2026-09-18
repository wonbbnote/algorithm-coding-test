class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combi(1, 0, 0, new ArrayList<>(), k, n, ans);
        return ans;
    }

    public void combi(int start, int nth, int sum, List<Integer> cases, int k, int n, List<List<Integer>> ans){

        if(sum > n){
            return;
        }

        if(nth == k && sum == n){
            System.out.println(cases);
            ans.add(new ArrayList<>(cases));
            return;
        }

        for(int i = start; i <= 9; i++){
            cases.add(i);
            combi(i + 1, nth + 1, sum + i, cases, k, n, ans);
            cases.remove(cases.size() - 1);
        }
    }
}