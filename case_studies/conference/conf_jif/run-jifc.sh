#!/bin/bash

verbString=""
if [ "$5" == "true" ];
then
    verbString="-e"
fi

echo $3

if [ "$4" == "all" ];
then
    $JIFHOME/bin/jifc $verbString -d "$2" -sourcepath "$1" -classpath "$3" $1/conf/*.jif
else
    $JIFHOME/bin/jifc $verbString -d "$2" -sourcepath "$1" -classpath "$3" $1/conf/$4.jif
fi
