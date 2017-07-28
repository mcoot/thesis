#!/bin/bash

verbString=""
if [ "$5" == "true" ];
then
    verbString="-e"
fi

if [ "$4" == "all" ];
then
    $JIFHOME/bin/jifc $verbString -d "$2" -classpath "$3:." $1/battleships/*.jif
else
    $JIFHOME/bin/jifc $verbString -d "$2" -classpath "$3:." $1/battleships/$4.jif
fi
