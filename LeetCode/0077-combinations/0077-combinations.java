class Solution {
    // 조합, 1 ~ n 중에 한개 선택 -> 선택한 수 위치 + 1 ~ n 까지의 수 중 에서 선택 k번 반복
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> case_lst = new ArrayList<>();
        combination(1, n, k, case_lst, result);

        return result;
        
    }

    public void combination(int start, int n, int k, List<Integer> case_lst, List<List<Integer>> result){

        if(case_lst.size() == k){
            result.add(new ArrayList<>(case_lst));
        }


        for(int i = start; i <= n; i++){
            case_lst.add(i);
            combination(i+1, n, k, case_lst, result);
            case_lst.remove(case_lst.size()-1);
        }


    }


}