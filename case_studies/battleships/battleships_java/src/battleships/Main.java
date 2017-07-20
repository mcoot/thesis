package battleships;

import java.io.PrintStream;

public class Main {

    public static final void main(String[] args) throws IllegalArgumentException {
        PrintStream out = System.out;

        new BattleShip().play(out);
    }

}
