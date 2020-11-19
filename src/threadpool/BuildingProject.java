package threadpool;

import java.util.concurrent.*;

public class BuildingProject {

    public static void main(String[] args) {
        project(100);
    }

    public static void project (int nums) {
        ExecutorService executorService;
        if (nums < 10) {
            executorService = Executors.newSingleThreadExecutor();
            for (int i = 0; i < nums; i++) {
                executorService.execute(new Task2());
            }

        } else if (nums >= 10 && nums < 100) {
            executorService = Executors.newFixedThreadPool(10);
            for (int i = 0; i < nums; i++) {
                executorService.execute(new Task2());
            }
        } else {
            project(nums, 5, 2);
        }
    }

    private static void project (int nums, int mon, int interval) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(nums);
        scheduledExecutorService.scheduleAtFixedRate(new Task2(), mon, interval, TimeUnit.SECONDS);
    }
}

class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println("工程队" + Thread.currentThread().getName() + "正在施工");
    }
}