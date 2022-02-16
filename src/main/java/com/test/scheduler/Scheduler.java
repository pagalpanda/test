
package com.test.scheduler;

import com.test.tasks.ScheduledTasks;


public interface Scheduler {
	void addTask(ScheduledTasks task);
	void start() throws InterruptedException;
}
