

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solveNQueens(N));
    }

    public static int solveNQueens(int n) {
        boolean[] cols = new boolean[n]; // 열에 퀸 유/무
        boolean[] diag1 = new boolean[2 * n - 1]; // 왼쪽 아래 대각선의 퀸 유/무
        boolean[] diag2 = new boolean[2 * n - 1]; // 오른쪽 아래 대각선의 퀸 유/무

        return dfs(0, n, cols, diag1, diag2);
    }

    private static int dfs(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            // 세로열의 퀸 존재, 왼쪽 아래 대각선의 퀸, 오른쪽 아래 대각선의 퀸 체크
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + n - 1]) {
                cols[col] = diag1[row + col] = diag2[row - col + n - 1] = true;
                // 다음 행에 대한 탐색
                count += dfs(row+1, n, cols, diag1, diag2);
                cols[col] = diag1[row + col] = diag2[row - col + n - 1] = false;
            }
        }

        return count;



    }
}
