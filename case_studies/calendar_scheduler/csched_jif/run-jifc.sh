#!/bin/bash

verbString=""
if [ "$5" == "true" ];
then
    verbString="-e"
elif [ "$5" == "debug" ];
then
    verbString="-e -report debug=2"
elif [ "$5" == "solver" ];
then
    verbString="-e -report solver=2"
fi

if [ "$4" == "all" ];
then
    $JIFHOME/../jif-3.4.3/bin/jifc $verbString -d "$2" -sourcepath "$1" -nonrobust -classpath "$3" -fail-on-exception $1/scheduler/*.jif
else
    $JIFHOME/../jif-3.4.3/bin/jifc $verbString -d "$2" -sourcepath "$1" -nonrobust -classpath "$3" -fail-on-exception $1/scheduler/$4.jif
fi
