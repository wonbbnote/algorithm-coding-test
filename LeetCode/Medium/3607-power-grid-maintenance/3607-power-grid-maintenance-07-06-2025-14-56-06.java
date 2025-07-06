import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Union-Find 초기화
        int[] parent = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
        }

        // 연결관계 Union 처리
        for (int[] conn : connections) {
            union(conn[0], conn[1], parent);
        }

        // 각 노드의 루트 재정의 (경로 압축 정리)
        for (int i = 1; i <= c; i++) {
            find(i, parent);
        }

        // 루트 → on 상태 노드 Set
        Map<Integer, TreeSet<Integer>> onlineMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = parent[i];
            onlineMap.computeIfAbsent(root, k -> new TreeSet<>()).add(i); // TreeSet: 정렬된 on 노드
        }

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int station = query[1];
            int root = parent[station];

            if (type == 2) {
                // 오프라인 처리: set에서 제거
                onlineMap.get(root).remove(station);
            } else {
                if (onlineMap.get(root).contains(station)) {
                    result.add(station);
                } else {
                    // 현재 on 상태인 노드 중 아무거나 꺼냄 (정렬되어 있으므로 가장 작은 값)
                    if (onlineMap.get(root).isEmpty()) {
                        result.add(-1);
                    } else {
                        result.add(onlineMap.get(root).first());
                    }
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
