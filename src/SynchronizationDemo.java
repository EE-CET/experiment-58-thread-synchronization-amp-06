class Table {

    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i);
            if (i < 5) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

class MyThread extends Thread {
    Table t;
    int num;

    MyThread(Table t, int num) {
        this.t = t;
        this.num = num;
    }

    public void run() {
        t.printTable(num);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {

        Table obj = new Table();

        MyThread t1 = new MyThread(obj, 5);
        MyThread t2 = new MyThread(obj, 100);

        t1.start();
        t1.join();   // Ensures first completes fully

        t2.start();
        t2.join();   // Ensures second completes fully
    }
}
