
package com.test.scheduler;

import com.test.tasks.ScheduledTasks;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author vagrant
 * @version $ 2/16/22
 */
public class OneTimeScheduler implements Scheduler{

    Queue<ScheduledTasks> tasks;

    public OneTimeScheduler(int capacity) {
        tasks = new ArrayBlockingQueue<>(capacity);
    }

    public void addTask(ScheduledTasks task) {
        tasks.add(task);
    }

    public void start() {
        new Thread(() -> {
            while(true) {
                while(!tasks.isEmpty()) {
                    ScheduledTasks task = tasks.poll();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            task.execute();
                        }
                    }, task.getTimeInterval() - System.currentTimeMillis());
                    tasks.remove(task);
                }
            }
        }).start();

    }
}
