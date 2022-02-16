
package com.test.service;

import com.test.Task;
import com.test.scheduler.OneTimeScheduler;
import com.test.scheduler.RepeatableScheduler;
import com.test.tasks.OneTimeTask;
import com.test.tasks.RepeatableTask;

import java.security.InvalidParameterException;


public class SchedulerService {
    private RepeatableScheduler repeatableScheduler;
    private OneTimeScheduler onetimeScheduler;

    public SchedulerService(int capacity) {
        repeatableScheduler = new RepeatableScheduler(capacity);
        onetimeScheduler = new OneTimeScheduler(capacity);
    }

    public void schedule(ScheduleKind kind, long time, Task task) {
        if(kind == ScheduleKind.REPEATABLE) {
            //start time is current time?
            repeatableScheduler.addTask(new RepeatableTask(task, time));
        } else if(kind == ScheduleKind.ONETIME) {
            onetimeScheduler.addTask(new OneTimeTask(task, time));
        } else {
            throw new InvalidParameterException();
        }
    }

    public void startService() {
        repeatableScheduler.start();
        onetimeScheduler.start();
    }
}