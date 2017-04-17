#!/bin/bash
cd "$1"
export CP=`cygpath $JIF_HOME/tests`
cd src/battleships
$JIF_HOME/bin/jifc -classpath $CP *.jif