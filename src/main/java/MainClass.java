import com.test.Task;
import com.test.service.ScheduleKind;
import com.test.service.SchedulerService;

public class MainClass {
    public static void main(String[] args) {
        int capacity = 500;
        SchedulerService ss = new SchedulerService(capacity);
        ss.startService();

        //Run the task once at some point of time in future
        ss.schedule(ScheduleKind.ONETIME, System.currentTimeMillis() + 15000, new Task("One time task 1"));
        ss.schedule(ScheduleKind.ONETIME, System.currentTimeMillis() + 17000, new Task("One time task 2"));
        ss.schedule(ScheduleKind.ONETIME, System.currentTimeMillis() + 20000, new Task("One time task 3"));


        //Repeat the tasks every 21 seconds
        ss.schedule(ScheduleKind.REPEATABLE, 21000, new Task("Repeatable task 1"));
        ss.schedule(ScheduleKind.REPEATABLE, 21000, new Task("Repeatable task 2"));
        //Repeat the tasks every 22 seconds
        ss.schedule(ScheduleKind.REPEATABLE, 22000, new Task("Repeatable task 3"));
    }
}
