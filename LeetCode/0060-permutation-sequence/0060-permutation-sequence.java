class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> num_list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            num_list.add(i);
        }

        List<Integer> result_list = new ArrayList<>();
        setValue(n, k, num_list, result_list);

        StringBuilder sb = new StringBuilder();
        for(Integer num: result_list){
            sb.append(num + "");
        }
        return sb.toString();
        
    }

    public void setValue(int n, int kth, List<Integer> num_list, List<Integer> result_list){
       
        if(num_list.size() == 1){
            result_list.add(num_list.get(0));
            return;
        }
        
        int added_index;
        int next_index;
        if(kth % factorial(n-1) == 0){
            added_index = kth / factorial(n-1) - 1;
            next_index = factorial(n-1);

        }else{
            added_index = kth / factorial(n-1);
            next_index = kth % factorial(n-1);
        }
        result_list.add(num_list.get(added_index));
        num_list.remove(added_index);
        setValue(n-1, next_index, num_list, result_list);
    }

    public int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}