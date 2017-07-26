#!/bin/bash

if [ "$1" == "all.para" ];
then
    parac-linux -p "./paralib:./out/parac/src:./extra" -o ./out/parac ./src/scheduler/InvalidMeetingException.para ./src/scheduler/User.para ./src/scheduler/Meeting.para ./src/scheduler/Calendar.para ./src/scheduler/Scheduler.para ./src/scheduler/Main.para
else
    parac-linux -p "./paralib:./out/parac/src:./extra" -o ./out/parac "./src/scheduler/$1"
fi