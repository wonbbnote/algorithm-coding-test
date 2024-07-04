import java.util.*;

public class Main {

    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {

        // INPUT
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] map = new int[M][N];
        for(int m = 0; m < M; m++){
            for(int n = 0; n < N; n++){
                map[m][n] = sc.nextInt();
            }
        }

        // 1을 세울 위치 선정하기
        // 0의 위치값 뽑기
        List<int[]> empty_loca = new ArrayList<>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == 0){
                    empty_loca.add(new int[] {i, j});
                }
            }
        }

        // 3군데 뽑을 경우의 수 구하기
        List<List<Integer>> case_list = new ArrayList<>();
        bactracking(0, new ArrayList<>(), case_list, empty_loca);

        // 각 경우의 수마다 map 변경하기
        int min_defected = 64;
        for(int i = 0; i < case_list.size(); i++){

            // 벽 세우기
            int[][] new_case_map = new int[M][N];
            for(int arr = 0; arr < new_case_map.length; arr++){
                System.arraycopy(map[arr], 0, new_case_map[arr], 0, map[0].length);
            }
            visited = new boolean[M][N];

            for(int j = 0; j < 3; j++){
                int idx = case_list.get(i).get(j);
                int changed_row = empty_loca.get(idx)[0];
                int changed_col = empty_loca.get(idx)[1];
                new_case_map[changed_row][changed_col] = 1;
            }

            // 감염된 위치 개수 구하기
            int defected_loca = 0;
            for(int m = 0; m < new_case_map.length; m++){
                for(int n = 0; n < new_case_map[0].length; n++){
                    if(new_case_map[m][n] == 2){
                        defected_loca += bfs(m, n, visited, new_case_map);
                    }
                }
            }

            if(defected_loca < min_defected){
                min_defected = defected_loca;
            }
        }

        int result = empty_loca.size() - min_defected - 3;
        System.out.println(result);

    }

    public static void bactracking(int start, List<Integer> case_one, List<List<Integer>> case_list, List<int[]> empty_loca){
        if(case_one.size() == 3){
            case_list.add(new ArrayList<>(case_one));
            return;
        }

        for(int i = start; i < empty_loca.size(); i++){
            case_one.add(i);
            bactracking(i+1, case_one, case_list, empty_loca);
            case_one.remove(case_one.size() - 1);
        }
    }

    public static int bfs(int m, int n, boolean[][] visited, int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {m, n});
        visited[m][n] = true;

        int defected = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cur_r = curr[0];
            int cur_c = curr[1];

            for(int i = 0; i < 4; i++){
                int nextRow = cur_r + dr[i];
                int nextCol = cur_c + dc[i];

                if(isValid(nextRow, nextCol, map)){
                    if(!visited[nextRow][nextCol]){
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[] {nextRow, nextCol});
                        defected++;
                    }
                }
            }
        }
        return defected;
    }

    private static boolean isValid(int nextRow, int nextCol, int[][] map) {
        return (nextRow >= 0 && nextRow < map.length) && (nextCol >= 0 && nextCol < map[0].length) && map[nextRow][nextCol] == 0;
    }
}
