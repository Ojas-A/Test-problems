class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Traverse rows and confirm
        // Traverse coolumns and confirm
        // Travers the 3 * 3 group and confirm 

        // Smarter - traverse the diagonal andcheck entire row and column
        int[] rowCheck = new int[10];
        int[] columnCheck = new int[10];

        for (int i = 0; i < board[0].length; i++) {
            for (int j = i ; j < board[0].length; j++) {

                for (int c = 0; c < 9; c++) {
                    if (board[i][c] == '.')
                        continue;
                    if (columnCheck[board[i][c] - '0'] == 0) {
                        columnCheck[board[i][c]- '0'] = 1;
                    } else {
                        return false;
                    }
                }
                for (int r = 0; r < 9; r++) {
                    if (board[r][j] == '.')
                        continue;
                    if (rowCheck[board[r][j]- '0'] == 0) {
                        rowCheck[board[r][j]- '0'] = 1;
                    } else {
                        return false;
                    }
                }
                Arrays.fill(rowCheck, 0);
                Arrays.fill(columnCheck, 0);
            }
        }

        for (int i = 1; i < 8; i = i+3) {
            for (int j = 1; j < 8; j = j+3) {
                Set check = new HashSet();
                for (int r = i-1; r< i+2; r++) {
                    for (int c = j-1; c < j+2; c++) {
                        if (board[r][c] == '.')
                            continue;
                        if (check.contains(board[r][c])) {
                            return false;
                        }
                        check.add(board[r][c]);
                    }
                }
            }
        }
        return true;
    }
}
