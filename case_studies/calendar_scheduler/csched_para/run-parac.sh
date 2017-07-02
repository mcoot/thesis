#!/bin/bash

parac-linux -p "./paralib:./src/scheduler:./out/parac" -o ./out/parac ./src/scheduler/Policy.para ./src/scheduler/WeekDay.para ./src/scheduler/User.para ./src/scheduler/CalendarException.para ./src/scheduler/CalendarEntry.para ./src/scheduler/Calendar.para ./src/scheduler/Scheduler.para ./src/scheduler/SchedulerApp.para