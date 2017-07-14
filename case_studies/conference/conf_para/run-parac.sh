#!/bin/bash

if [ "$1" == "all.para" ];
then
    parac-linux -p "./paralib:./src/conf:./out/parac/src" -o ./out/parac ./src/conf/Author.para ./src/conf/Paper.para ./src/conf/ConferenceSystem.para ./src/conf/Main.para
else
    parac-linux -p "./paralib:./src/conf:./out/parac/src" -o ./out/parac "./src/conf/$1"
fi