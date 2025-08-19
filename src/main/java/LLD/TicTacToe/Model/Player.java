package LLD.TicTacToe.Model;

import lombok.Data;

@Data
public abstract class Player {
    private String name;
    private SymbolC symbolC;

    Player(String name, SymbolC symbolC) {
        this.name = name;
        this.symbolC = symbolC;
    }
}
