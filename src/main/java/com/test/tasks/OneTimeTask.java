

package com.test.tasks;

import com.test.Task;

public class OneTimeTask implements ScheduledTasks{
    private Task task;
    long timeInterval;

    public OneTimeTask(Task task, long time) {
        this.task = task;
        this.timeInterval = time;
    }

    @Override
    public long getTimeInterval() {
        return timeInterval;
    }

    @Override
    public void execute() {
        task.execute();
    }
}
