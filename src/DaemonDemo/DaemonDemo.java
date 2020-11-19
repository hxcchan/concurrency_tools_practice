package DaemonDemo;

/**
 * A demo for daemon threads.
 * JVM will exit after all user threads finish executing.
 * */
public class DaemonDemo {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();
        threadC.setDaemon(true);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

class ThreadA extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Tharead A" + i);
        }
    }
}

class ThreadB extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Tharead B" + i);
        }
    }
}

class ThreadC extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Tharead C" + i);
        }
    }
}