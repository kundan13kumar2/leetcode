package LLD.TicTacToe.Model;


import lombok.Data;

@Data
public class Board {
    int size;
    SymbolC[][] board;

    public Board(int size) {
        this.size = size;
        board = new SymbolC[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j]!=null){
                    System.out.print(board[i][j].getSymbol().name()+" ");
                }else {
                    System.out.print(" ");
                }
                System.out.print(" |");
            }
            System.out.println();
        }
    }

    public boolean isThereFreeSpace() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFreeCellThenAssign(int row, int col, SymbolC symbolC) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = symbolC;
        return true;
    }
}
