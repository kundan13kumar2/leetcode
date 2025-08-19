package design.snakeladder;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameBoard {

    private Dice dice;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private Queue<Player> players;
    Map<String, Integer> playerCurrentPosition;
    int boardSize;

    public GameBoard(Dice dice, List<Jumper> snakes, List<Jumper> ladders, Queue<Player> players, Map<String, Integer> playerCurrentPosition, int boardSize) {
        this.dice = dice;
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
        this.playerCurrentPosition = playerCurrentPosition;
        this.boardSize = boardSize;
    }

    public void playGame() {
        while (players.size() > 1) {
            Player p = players.poll();
            int currPosition = playerCurrentPosition.get(p.playerName);
            int diceValue = dice.getDiceValue();
            int nextCell = currPosition + diceValue;
            if (nextCell > boardSize) players.offer(p);
            if (nextCell == boardSize) System.out.println("Won " + p.playerName);
            else {
                int nextPosition = nextCell;
                boolean b = false;
                for (Jumper j : snakes) {
                    if (nextCell == j.startPoint) {
                        nextPosition = j.endPoint;
                        break;
                    }
                }
                if (nextCell != nextPosition) System.out.println("Bitten by snakes ");

                for (Jumper j : ladders) {
                    if (j.startPoint == nextCell) {
                        nextPosition = j.endPoint;
                        b = true;
                    }
                }
                if (nextPosition != nextCell && b)
                    System.out.println("Ladder came");
                if (nextPosition == boardSize)
                    System.out.println("won");
                else {
                    playerCurrentPosition.put(p.playerName, nextPosition);
                    System.out.println();
                    players.offer(p);
                }
            }
        }
    }

}
