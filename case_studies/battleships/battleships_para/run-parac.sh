#!/bin/bash

if [ "$1" == "all.para" ];
then
    parac-linux -p "./paralib:./src/conf:./out/parac/src:./extra" -o ./out/parac ./src/battleships/Coordinate.para ./src/battleships/Ship.para ./src/battleships/Board.para ./src/battleships/Policy.para ./src/battleships/Player.para ./src/battleships/BattleShip.para ./src/battleships/Main.para
else
    parac-linux -p "./paralib:./src/conf:./out/parac/src:./extra" -o ./out/parac "./src/battleships/$1"
fi