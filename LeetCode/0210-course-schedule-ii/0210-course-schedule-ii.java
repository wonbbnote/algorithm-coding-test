import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 인접리스트, 위상 정렬 행렬 초기화
        int[] arr = new int[numCourses];
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            arr[prerequisites[i][0]]++;
        }


        // 앞에 아무것도 없는 것 즉, 0인 것 큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(arr[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res.add(curr);

            for(int next: adj[curr]){
                arr[next]--;
                if(arr[next] == 0){
                    queue.add(next);
                }
            }

        }

        if(res.size() != numCourses){
            return new int[] {};
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
        
    }
}