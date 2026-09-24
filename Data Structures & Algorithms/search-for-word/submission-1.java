class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(board, word, 0, row, col, new boolean[rows][cols])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        boolean result = dfs(board, word, index + 1, row + 1, col, visited) || dfs(board, word, index + 1, row - 1, col, visited) ||
        dfs(board, word, index + 1, row, col + 1, visited) || dfs(board, word, index + 1, row, col - 1,visited);

        visited[row][col] = false;
        return result;
    }
}
