package LLD.TicTacToe;

import LLD.TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    Board board;
    Deque<Player> playerList;

    Game() {
        initializeGame();
    }

    void initializeGame() {
        playerList = new LinkedList<>();
        board = new Board(3);
        Player playerX = new PlayerX();
        Player playerO = new PlayerO();
        playerList.add(playerX);
        playerList.add(playerO);
    }

    public String startGame() {

        boolean noWinner = true;
        while (noWinner) {
            Player turnPlayer = playerList.removeFirst();
            board.printBoard();
            if (!board.isThereFreeSpace()) {
                noWinner = false;
                continue;
            }
            System.out.print("Player:" + turnPlayer.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean foundFreeCell = board.isFreeCellThenAssign(inputRow, inputColumn, turnPlayer.getSymbolC());
            if (!foundFreeCell) {
                System.out.println("Incorrect position chosen, try again");
                playerList.addFirst(turnPlayer);
                continue;
            }
            playerList.addLast(turnPlayer);

            boolean winner = isThereWinner(inputRow, inputColumn, turnPlayer.getSymbolC());
            if (winner) {
                return turnPlayer.getName();
            }
        }
        return "Tie";
    }

    //Implement NQueen Problem
    public boolean isThereWinner(int row, int column, SymbolC symbolC) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for (int i = 0; i < board.getSize(); i++) {

            if (board.getBoard()[row][i] == null || board.getBoard()[row][i].getSymbol() != symbolC.getSymbol()) {
                rowMatch = false;
            }
        }

        //need to check in column
        for (int i = 0; i < board.getSize(); i++) {

            if (board.getBoard()[i][column] == null || board.getBoard()[i][column].getSymbol() != symbolC.getSymbol()) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for (int i = 0, j = 0; i < board.getSize(); i++, j++) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j].getSymbol() != symbolC.getSymbol()) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for (int i = 0, j = board.getSize() - 1; i < board.getSize(); i++, j--) {
            if (board.getBoard()[i][j] == null || board.getBoard()[i][j].getSymbol() != symbolC.getSymbol()) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


}
