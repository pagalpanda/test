
package com.test.scheduler;

import com.test.tasks.ScheduledTasks;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RepeatableScheduler implements Scheduler{
    Queue<ScheduledTasks> tasks;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public RepeatableScheduler(int capacity) {
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
                    scheduler.scheduleAtFixedRate(() -> task.execute(), task.getTimeInterval(), task.getTimeInterval(), TimeUnit.MILLISECONDS);
                    tasks.remove(task);
                }
            }
        }).start();

    }

}
