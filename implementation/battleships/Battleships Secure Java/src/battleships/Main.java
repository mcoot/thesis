package battleships;

import java.io.PrintStream;

public class Main {
	
	public static final void main(String[] args) {
		PrintStream out = System.out;

		new BattleShip().play(out);
	}

}