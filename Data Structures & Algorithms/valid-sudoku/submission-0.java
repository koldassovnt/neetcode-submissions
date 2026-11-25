class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check row and column
        for (int i = 0; i < board.length; i++) {
            Set<Integer> seenRow = new HashSet<>();
            Set<Integer> seenCol = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (seenRow.contains(num)) {
                        return false;
                    }
                    seenRow.add(num);
                }
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if (seenCol.contains(num)) {
                        return false;
                    }
                    seenCol.add(num);
                }
            }
        }

        // check 3x3 block
        Map<Integer, Set<Character>> boxes = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int boxId = (i / 3) * 3 + (j / 3);
                    Set<Character> boxSeen = boxes.getOrDefault(boxId, new HashSet<>());
                    if (boxSeen.contains(board[i][j])) {
                        return false;
                    }
                    boxSeen.add(board[i][j]);
                    boxes.computeIfAbsent(boxId, k -> boxSeen);
                }
            }
        }

        return true;
    }
}
