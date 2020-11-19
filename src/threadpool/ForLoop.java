package threadpool;

import java.util.concurrent.Executors;

public class ForLoop {

    public static void main(String[] args) {
       for (int i = 0; i < 10; i++) {
           Thread thread = new Thread(new EveryTaskOneThread.Task());
           thread.start();
       }
    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("Running task...");
        }
    }
}
