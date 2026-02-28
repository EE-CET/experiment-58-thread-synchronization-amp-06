class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.print(n * i + " ");
        }
        System.out.println(); // IMPORTANT: newline after each table
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
    public static void main(String[] args) {
        Table obj = new Table();

        MyThread t1 = new MyThread(obj, 5);
        MyThread t2 = new MyThread(obj, 100);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
