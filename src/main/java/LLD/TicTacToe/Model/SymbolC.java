package LLD.TicTacToe.Model;

import lombok.Data;

@Data
public class SymbolC {
    Symbol symbol;

    SymbolC(Symbol symbol) {
        this.symbol = symbol;
    }
}
