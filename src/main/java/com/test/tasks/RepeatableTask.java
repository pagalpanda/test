
package com.test.tasks;

import com.test.Task;

public class RepeatableTask implements ScheduledTasks {
    private Task task;
    private long timeInterval;
    public RepeatableTask(Task task, long time) {
        this.task = task;
        this.timeInterval = time;
    }

    public long getTimeInterval() {
        return timeInterval;
    }

    @Override
    public void execute() {
        task.execute();
    }


}
