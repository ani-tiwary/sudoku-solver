public class SudokuSolver {
    private final Cell[][] board;
    public SudokuSolver() {
        board = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new Cell();
            }
        }
    }
    public void initializeBoard(String input) {
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = input.charAt(index);
                if (ch != 'l') {
                    int number = Character.getNumericValue(ch);
                    Cell cell = board[i][j];
                    cell.setNumber(number);
                    cell.setFilled(true);
                }
                index++;
            }
        }
    }
    public boolean isValidEntry(int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getNumber() == number) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col].getNumber() == number) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j].getNumber() == number) {
                    return false;
                }
            }
        }
        return true;
    }
    public String printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append("---------------------\n");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    sb.append("| ");
                }
                Cell cell = board[i][j];
                if (cell.isFilled()) {
                    sb.append(cell.getNumber()).append(" ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public String solve(String input) {
        initializeBoard(input);
        boolean isSolved = solveSudoku();
        if (isSolved) {
            return printBoard();
        } else {
            return "";
        }
    }
    private boolean solveSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Cell cell = board[row][col];
                if (!cell.isFilled()) {
                    for (Entry entry : cell.getEntries()) {
                        int number = entry.getNumber();
                        if (isValidEntry(row, col, number)) {
                            cell.setNumber(number);
                            cell.setFilled(true);
                            if (solveSudoku()) {
                                return true;
                            }
                            cell.setNumber(0);
                            cell.setFilled(false);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
